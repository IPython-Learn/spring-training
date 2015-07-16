package com.lyris.mesa.message.tx;

import java.util.concurrent.TimeUnit;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.hazelcast.core.IMap;
import com.lyris.mesa.message.MessageContext;
import com.lyris.mesa.message.MessageContextBuilder;
import com.lyris.mesa.tracker.Tracker;

/**
 * Class that provides transactional capabilities. A transaction here has a different meaning. The lifecycle is as below:
 * <ul>
 * <li>The first step is to obtain a ITxContext object and can be created via the TxContext.forContext() api.
 * <p>
 * If a service implementation receives a message request for the first time, MuleMessage object will not have the MsgRedelivered, MsgDeliveryCount,
 * MsgContextId inbound properties. When a message is redelivered to the same service implementation, these 3 properties will be available on MuleMessage as
 * inbound properties.
 * <p>
 * If the MuleMessage has the inbound property MsgContextId, it should be used to create the TxContext object as below:
 * <p>
 * <code>TxContext.forContext(msgContextId)</code></li>
 * <li>On the obtained ITxContext object, we can begin the transaction via ITxContext.beginTx(). This will create a MessageContext object and persist to the
 * hazelcast cache</li>
 * <li>To commit the transaction, use <code>ITxContext.commitTx()</code>. This would remove the MessageContext object (identified by MsgContextId) from the
 * hazelcast cache.</li>
 * <li>To deliver the MessageContext that is wrapped by the current TxContext, delegate to <code>ITxContext.redeliverTx()</code>. This would update the
 * nextDispatchTimestamp on the MessageContext object and update the hazelcast cache. This will be picked up for redelivery by MessageContextDispatcher</li>
 * </ul>
 * <p>
 * Example:
 * <p>
 * The below TxContext sets up for myQueue with a maxRetryCount of 10 and message delivery is 1 hour
 * 
 * <pre>
 * <code>
 * ITxContext tx = TxContext.forContext("myQueue", muleMessage.getPayload(), 10, TimeUnit.HOURS, 1);
 * try {
 *     tx.beginTx();
 *     // Process your business logic
 *     ...
 *     ...
 *     // finally call the commitTx()
 *     tx.commitTx();
 * } catch(final SomeException se) {
 *     tx.redeliverTx();
 * }
 * </code>
 * 
 * @author nyakkala
 * @author cveerapaneni
 * 
 */
public class TxContext implements ITxContext {

    /** Reference to the logger */
    private static final Logger LOGGER = Logger.getLogger(TxContext.class);

    /** MessageContext object holding the contextual information about the message against which the transaction capabilities are applied */
    private final MessageContext messageContext;

    /** Boolean indicating if the transaction has been committed. If yes, repeated commits have no effect */
    private boolean committed = false;

    /** Boolean indicating if the transaction has been redelivered. If yes, repeated redelivers have no effect */
    private boolean redelivered = false;

    /** Reference to the IMapTrackerClient instance for the messageDelivery map in hazelcast */
    private static final IMap<String, MessageContext> client = Tracker.getMessageContextMap();

    /**
     * Private constructor
     * 
     * @param messageContext
     *            MessageContext object holding the contextual information about the message against which the transaction capabilities are applied
     */
    private TxContext(final MessageContext messageContext) {
        // Private constructor to prevent creation of objects of this class.
        this.messageContext = messageContext;
    }

    /**
     * Creates a transaction context based on the provided messageContextId. Use this api IF AND ONLY IF the MuleMessage object has "MsgRedelivered" inbound
     * property as true. Message context id can be retrieved from the MuleMessage as an inbound property "MessageContextId". Attempting to use this api without
     * considering "MsgRedelivered" or "MessageContextId" inbound properties has a side-effect of a message being delivered multiple times.
     * <p>
     * This method retrieves the message context details based on the provided id from the hazelcast cache and uses it for applying transaction capabilities.
     * Applications can get a handle to this via the MuleMessage properties and will be available when a message is redelivered to the destination as configured
     * in the MessageContext
     * 
     * @param messageContextId
     *            Message context id
     * @return Transaction context object that wraps the MessageContext object identified by the provided messageContextId
     * @throws IllegalArgumentException
     *             Thrown when the provided messageContextId is invalid (null or empty)
     */
    public static ITxContext forContext(final String messageContextId) throws IllegalArgumentException {
        if (StringUtils.isBlank(messageContextId)) {
            throw new IllegalArgumentException("Message context id [" + messageContextId + "] cannot be null/empty.");
        }

        // Hit the hazelcast & find the MessageContext object based on the provided messageContextId
        final MessageContext messageContext = TxContext.client != null ? TxContext.client.get(messageContextId) : null;
        if (messageContext == null) {
            TxContext.LOGGER.warn("Unable to find MessageContext with messageContextId: " + messageContextId + ". Using a NoOpTxContext.");
            return new NoOpTxContext();
        }
        return new TxContext(messageContext);
    }

    /**
     * Creates a Transaction context object for the provided contextual details. Use this api IF AND ONLY IF the MuleMessage object has "MsgRedelivered" inbound
     * property as false. Attempting to use this without considering "MsgRedelivered" inbound property has a side-effect of a message being delivered multiple
     * times.
     * 
     * @param destinationQueue
     *            Destination queue name without the protocol information
     * @param payload
     *            Message payload
     * @param maxRetryCount
     *            Maximum number of times the message needs to be re-delivered
     * @param timeUnit
     *            TimeUnit (TimeUnit.SECONDS, TimeUnit.MINUTES, TimeUnit.HOURS and TimeUnit.DAYS are the only supported values)
     * @param deliveryInterval
     *            Delivery interval between two deliveries and the value is based on timeUnit
     * @return Transaction context object that wraps the MessageContext object with the provided details
     * @throws IllegalArgumentException
     *             Thrown when the inputs provided are invalid
     */
    public static ITxContext forContext(final String destinationQueue, final Object payload, final Integer maxRetryCount, final TimeUnit timeUnit,
            final Long deliveryInterval) throws IllegalArgumentException {
        // Validate of the inputs are done in the MessageContextBuilder. Build the message context object. Note that, the object is not persisted to hazelcast
        // until a beginTx() is called.
        final MessageContext msgContext = new MessageContextBuilder().forDestinationQueue(destinationQueue).withPayload(payload)
                .usingMaxRetryCount(maxRetryCount).withDeliveryInterval(timeUnit, deliveryInterval).forDeliveryCount(0).get();

        return new TxContext(msgContext);
    }

    /**
     * If this TxContext has not been committed and redelivered, the MessageContext object wrapped by this TxContext will be inserted to the hazelcast cache.
     */
    @Override
    public void beginTx() {
        final String mcId = messageContext.getMessageContextId();
        TxContext.LOGGER.info("beginTx: messageContextId: " + mcId);
        if (committed || redelivered) {
            TxContext.LOGGER.info("messageContextId: " + mcId + ", Cannot begin a transaction that is already committed or redelivered.");
        } else {
            TxContext.LOGGER.info("Adding messageContextId: " + mcId + " to hazelcast cache");
            messageContext.setProcessing(true);
            // Add the MessageContext object to the hazelcast cache if the transaction is a new one
            TxContext.client.put(mcId, messageContext);
        }
    }

    /**
     * Commits the transaction by removing from the Hazelcast cache the messageContext object wrapped by this transaction context.
     */
    @Override
    public void commitTx() {
        final String mcId = messageContext.getMessageContextId();
        TxContext.LOGGER.info("commitTx: messageContextId: " + mcId);
        if (committed) {
            TxContext.LOGGER.info("messageContextId: " + mcId + ", Cannot commit a transaction that has already been committed.");
        } else {
            if (redelivered) {
                TxContext.LOGGER.info("messageContextId: " + mcId
                        + ", Transaction has already been redelivered. Cannot commit a redelivered transaction in the same TxContext");
            } else {
                try {
                    TxContext.LOGGER.info("Deleting messageContextId: " + mcId + " from hazelcast cache");
                    TxContext.client.delete(mcId);
                    committed = true;
                } catch (final Exception ex) {
                    TxContext.LOGGER.error("Exception occured while committing the messageContextId:" + mcId);
                }
            }
        }
    }

    /**
     * Updates the messageContext object wrapped by this transaction context with the next dispatch timestamp & delivery count & inserts back to hazelcast
     * cache. The object is not removed from the cache.
     */
    @Override
    public void redeliverTx() {
        final String mcId = messageContext.getMessageContextId();
        TxContext.LOGGER.info("redeliverTx: messageContextId: " + mcId);
        if (redelivered) {
            TxContext.LOGGER.debug("messageContextId: " + mcId + ", Cannot redeliver a transaction that has already been redelivered.");
        } else {
            // TODO: Should it be from current timestamp or from earlier dispatchTimestamp?
            messageContext.setNextDispatchTimestamp(System.currentTimeMillis() + messageContext.getDeliveryInterval());
            messageContext.setDeliveryCount(messageContext.getDeliveryCount() + 1);
            messageContext.setProcessing(false);

            TxContext.LOGGER.info("Updating messageContextId: " + mcId + " in hazelcast cache with nextDispatchTimestamp: "
                    + messageContext.getNextDispatchTimestamp() + ", deliveryCount: " + messageContext.getDeliveryCount() + ", processing: false");

            // Put it back
            TxContext.client.put(messageContext.getMessageContextId(), messageContext);
            redelivered = true;
        }
    }

    // -----------------------------------------------------------------------------------------------------------------------------
    // Private Helper Methods
    // -----------------------------------------------------------------------------------------------------------------------------
}
