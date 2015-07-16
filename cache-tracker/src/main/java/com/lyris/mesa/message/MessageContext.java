package com.lyris.mesa.message;

import java.io.Serializable;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * Class that wraps the contextual information about a message and includes details like Payload, destination queue to which the delivery needs to be done,
 * maximum number of times the delivery should be attempted and the current delivery attempt.
 * 
 * @author nyakkala
 * @author cveerapaneni
 */
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class MessageContext implements Serializable, Comparable<MessageContext> {
    /** Serial version UID */
    private static final long serialVersionUID = 1L;

    /** Reference to the MessageRedelivered property */
    public static final String PROPERTY_MESSAGE_REDELIVERED = "MsgRedelivered";

    /** Reference to the MessageRedelivered property */
    public static final String PROPERTY_MESSAGE_DELIVERY_COUNT = "MsgDeliveryCount";

    /** Reference to the MessageRedelivered property */
    public static final String PROPERTY_MESSAGE_CONTEXT_ID = "MsgContextId";

    /** Reference to the messageContextMap */
    public static final String KEY_MESSAGE_CONTEXT_MAP = "messageContext.map.name";

    /** Unique Id */
    private String messageContextId;

    /** Reference to the payload object */
    private Object payload;

    /** Next dispatch timestamp in epoch time */
    private long nextDispatchTimestamp;

    /** Destination queue name */
    private String destinationQueue;

    /** Maximum Retry attempts */
    private int maxRetryCount;

    /** Delivery count indicating how many times the message has been delivered. If 0, it indicates that the message is delivered for the first time. */
    private int deliveryCount;

    /** deliveryInterval in milliseconds */
    private long deliveryInterval;

    /** flag that indicates if this message context is being processed. Defaulted to false */
    private boolean processing;

    /**
     * Returns the unique message context id
     * 
     * @return Message context id and will be unique in the hazelcast map
     */
    public String getMessageContextId() {
        return messageContextId;
    }

    /**
     * Sets the id of the MessageContext object to the provided value
     * 
     * @param messageContextId
     *            Message context id
     */
    public void setMessageContextId(final String messageContextId) {
        this.messageContextId = messageContextId;
    }

    /**
     * Returns the payload set on this object
     * 
     * @return Message payload
     */
    public Object getPayload() {
        return payload;
    }

    /**
     * Sets the payload to the provided payload
     * 
     * @param payload
     *            Message payload
     */
    public void setPayload(final Object payload) {
        this.payload = payload;
    }

    /**
     * Returns the next dispatch timestamp in milliseconds (epoch time) indicating when this MessageContext object needs to be considered for redelivery.
     * 
     * @return Next dispatch timestamp in milliseconds (epoch time)
     */
    public long getNextDispatchTimestamp() {
        return nextDispatchTimestamp;
    }

    /**
     * Sets the next dispatch time to the provided timestamp.
     * 
     * @param nextDispatchTimestamp
     *            Next dispatch timestamp in milliseconds (epoch time) indicating when this MessageContext object needs to be considered for redelivery.
     */
    public void setNextDispatchTimestamp(final long nextDispatchTimestamp) {
        this.nextDispatchTimestamp = nextDispatchTimestamp;
    }

    /**
     * Returns the destination queue name to which this RedeliveryPolicy object will be delivered when it is due for delivery (based on dispatchTimestamp).
     * 
     * @return Destination queue name to which this RedeliveryPolicy object will be delivered.
     */
    public String getDestinationQueue() {
        return destinationQueue;
    }

    /**
     * Sets the destination queue name to the provided queue name
     * 
     * @param destinationQueue
     *            Destination queue name
     */
    public void setDestinationQueue(final String destinationQueue) {
        this.destinationQueue = destinationQueue;
    }

    /**
     * Returns the maximum number of times the dispatcher would attempt to re-deliver this MessageContext object
     * 
     * @return Maximum retry count
     */
    public int getMaxRetryCount() {
        return maxRetryCount;
    }

    /**
     * Sets the maximum retry count to the provided value
     * 
     * @param maxRetryCount
     *            Maximum retry count
     */
    public void setMaxRetryCount(final int maxRetryCount) {
        this.maxRetryCount = maxRetryCount;
    }

    /**
     * Returns the current delivery count. A value of 1 indicates that it is a first time delivery. Any value > 1 indicates the redelivery count.
     * 
     * @return Delivery count
     */
    public int getDeliveryCount() {
        return deliveryCount;
    }

    /**
     * Sets the delivery count to the provided value
     * 
     * @param deliveryCount
     *            Delivery count
     */
    public void setDeliveryCount(final int deliveryCount) {
        this.deliveryCount = deliveryCount;
    }

    /**
     * Returns the delivery interval (in milliseconds). It indicates the interval between two deliveries.
     * 
     * @return Delivery interval in milliseconds
     */
    public long getDeliveryInterval() {
        return deliveryInterval;
    }

    /**
     * Sets the delivery interval to the provided value.
     * 
     * @param deliveryInterval
     *            Delivery interval in milliseconds
     */
    public void setDeliveryInterval(final long deliveryInterval) {
        this.deliveryInterval = deliveryInterval;
    }

    /**
     * Returns a boolean indicating if the MessageContext object is being processed currently
     * 
     * @return true if this MessageContext object is being processed false otherwise.
     */
    public boolean isProcessing() {
        return processing;
    }

    /**
     * Sets the processing flag to the provided value
     * 
     * @param processing
     *            true indicates that this MessageContext object is being processed false otherwise
     */
    public void setProcessing(final boolean processing) {
        this.processing = processing;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (destinationQueue == null ? 0 : destinationQueue.hashCode());
        result = prime * result + (messageContextId == null ? 0 : messageContextId.hashCode());
        return result;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof MessageContext)) {
            return false;
        }

        final MessageContext other = (MessageContext) obj;
        if (destinationQueue == null) {
            if (other.destinationQueue != null) {
                return false;
            }
        } else if (!destinationQueue.equals(other.destinationQueue)) {
            return false;
        }
        if (messageContextId == null) {
            if (other.messageContextId != null) {
                return false;
            }
        } else if (!messageContextId.equals(other.messageContextId)) {
            return false;
        }
        return true;
    }

    @Override
    public int compareTo(final MessageContext other) {
        return Long.valueOf(nextDispatchTimestamp).compareTo(Long.valueOf(other.getNextDispatchTimestamp()));
    }

    @Override
    public String toString() {
        return "MessageContext [id=" + messageContextId + ", destinationQueue=" + destinationQueue + ", maxRetryCount=" + maxRetryCount + ", payload="
                + payload + ", deliveryCount=" + deliveryCount + ", nextDispatchTimestamp=" + nextDispatchTimestamp + "]";
    }
}
