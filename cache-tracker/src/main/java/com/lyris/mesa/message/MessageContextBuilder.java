package com.lyris.mesa.message;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang.StringUtils;

/**
 * MessageContextBuilder class that provides fluent apis to build the MessageContext object.
 * 
 * @author nyakkala
 * @author cveerapaneni
 * 
 */
public final class MessageContextBuilder {
    /** Reference to the prefix that will be used for every MessageContext */
    private static final String PREFIX_MSG_CONTEXT_ID = "msg-";

    /** Reference to the JMS protocol that will be prepended to the destination queue if not present */
    private static final String PREFIX_JMS_PROTOCOL = "jms://";

    /** Reference to MessageContext object */
    private final MessageContext messageContext;

    /**
     * Private constructor
     */
    public MessageContextBuilder() {
        messageContext = new MessageContext();
    }

    /**
     * Returns the MessageDetails object and should always be called last after calling all the methods on this class which populate the MessageDetails object.
     * 
     * @return MessageContext object
     */
    public MessageContext get() {
        // Generate the messageContextId now
        final String messageContextId = MessageContextBuilder.PREFIX_MSG_CONTEXT_ID + UUID.randomUUID().toString();
        messageContext.setMessageContextId(messageContextId);

        return messageContext;
    }

    /**
     * Sets the destination queue name to the provided value. Throws an IllegalArgumentException if an invalid value is provided (null or empty). This method
     * adds the protocol information to the provided destination queue (i.e. prepends jms://)
     * 
     * @param destinationQueue
     *            Destination queue name without the protocol
     * @return Updated instance of this class
     * @throws IllegalArgumentException
     *             Thrown when the provided destination queue name is invalid (null or empty).
     */
    public MessageContextBuilder forDestinationQueue(final String destinationQueue) throws IllegalArgumentException {
        // Destination queue cannot be null or empty
        if (StringUtils.isBlank(destinationQueue)) {
            throw new IllegalArgumentException("Destination queue [" + destinationQueue + "] cannot be null/empty.");
        }
        messageContext.setDestinationQueue(destinationQueue.startsWith(MessageContextBuilder.PREFIX_JMS_PROTOCOL) ? destinationQueue
                : MessageContextBuilder.PREFIX_JMS_PROTOCOL + destinationQueue);
        return this;
    }

    /**
     * Sets the payload to the provided value and cannot be null.
     * 
     * @param payload
     *            The payload that will be dispatched to the destination queue after the dispatchTimestamp
     * @return Updated instance of this class
     * @throws IllegalArgumentException
     *             Thrown when the provided payload is null (or empty if it happens to be a string)
     */
    public MessageContextBuilder withPayload(final Object payload) throws IllegalArgumentException {
        // Payload cannot be null
        if (payload == null || payload instanceof String && StringUtils.isBlank(payload.toString())) {
            throw new IllegalArgumentException("Payload [" + payload + "] cannot be null/empty.");
        }
        messageContext.setPayload(payload);
        return this;
    }

    /**
     * Sets the maximum retry count to the provided value. Throws an IllegalArgumentException if an invalid value is provided.
     * 
     * @param maxRetryCount
     *            Maximum retry count
     * @return Updated instance of this class
     * @throws IllegalArgumentException
     *             Thrown when the provided maxRetryCount is invalid (zero or less)
     */
    public MessageContextBuilder usingMaxRetryCount(final int maxRetryCount) throws IllegalArgumentException {
        // Max retry count cannot be <= 0
        if (maxRetryCount <= 0) {
            throw new IllegalArgumentException("Max retry count[" + maxRetryCount + "] should be a positive value greater than zero.");
        }
        messageContext.setMaxRetryCount(maxRetryCount);
        return this;
    }

    /**
     * Sets the delivery interval (gap) between two deliveries.
     * 
     * @param timeUnit
     *            TimeUnit for deliveryInterval. Supported values are TimeUnit.SECONDS, TimeUnit.MINUTES, TimeUnit.HOURS, TimeUnit.DAYS.
     * @param deliveryInterval
     *            Delivery interval based on the specified time unit
     * @return Updated instance of this class
     * @throws IllegalArgumentException
     *             Thrown when the provided timeUnit is not one of the supported values (TimeUnit.SECONDS, TimeUnit.MINUTES, TimeUnit.HOURS, TimeUnit.DAYS) or
     *             the deliveryInterval has invalid value (<= 0).
     */
    public MessageContextBuilder withDeliveryInterval(final TimeUnit timeUnit, final long deliveryInterval) throws IllegalArgumentException {
        // Delivery interval cannot be <= 0
        if (deliveryInterval <= 0) {
            throw new IllegalArgumentException("Delivery interval[" + deliveryInterval + "] should be a positive value greater than zero.");
        }

        long deliveryIntervalInMillis;
        switch (timeUnit) {
            case SECONDS: {
                deliveryIntervalInMillis = deliveryInterval * 1000;
                break;
            }
            case MINUTES: {
                deliveryIntervalInMillis = deliveryInterval * 60 * 1000;
                break;
            }
            case HOURS: {
                deliveryIntervalInMillis = deliveryInterval * 60 * 60 * 1000;
                break;
            }
            case DAYS: {
                deliveryIntervalInMillis = deliveryInterval * 24 * 60 * 60 * 1000;
                break;
            }
            default: {
                // TimeUnit.NANOSECONDS, TimeUnit.MICROSECONDS, TimeUnit.MILLISECONDS are not supported
                throw new IllegalArgumentException("Provided timeUnit [" + timeUnit + "] is not supported. Only SECONDS, MINUTES, HOURS, DAYS are supported.");
            }
        }
        messageContext.setDeliveryInterval(deliveryIntervalInMillis);
        return this;
    }

    /**
     * Sets the delivery count to the provided value. If an invalid value is provided (zero or below), resets to 1. A value of 1 always indicates first
     * delivery. Any value > 1, indicates the redelivery count.
     * 
     * @param deliveryCount
     *            Current delivery count
     * @return Updated instance of this class
     */
    public MessageContextBuilder forDeliveryCount(final int deliveryCount) {
        // If the delivery count is <= 0, default to 0
        messageContext.setDeliveryCount(deliveryCount <= 0 ? 1 : deliveryCount);
        return this;
    }
}
