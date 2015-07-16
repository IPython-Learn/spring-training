package com.lyris.mesa.model.campaign;

import java.io.Serializable;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.google.gson.annotations.Expose;

/**
 * Class that represents the schedule item and contains the dispatch timestamp as epoch time (number of milliseconds that have elapsed from 01-Jan-1970) and the
 * contact set id.
 * 
 * @author cveerapaneni
 * 
 */
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class ScheduleItem implements Serializable, Comparable<ScheduleItem> {
    /** Default serial version UID */
    private static final long serialVersionUID = 1L;

    /** Reference to the dispatch timestamp represented as epoch time (number of milliseconds that have elapsed from 01-Jan-1970) */
    @Expose
    private long dispatchTimestamp;

    /** Reference to the string that represents the contact set id */
    @Expose
    private String contactSetId;

    /** Reference to an integer that represents the operation number to which this schedule item is associated to */
    @Expose
    private Integer operationNumber;

    /**
     * Returns the dispatch timestamp as epoch time
     * 
     * @return Timestamp as epoch time
     */
    public long getDispatchTimestamp() {
        return dispatchTimestamp;
    }

    /**
     * Sets the dispatch timestamp
     * 
     * @param dispatchTimestamp
     *            Timestamp for dispatching process and should be in epoch time (number of milliseconds that have elapsed from 01-Jan-1970
     */
    public void setDispatchTimestamp(final long dispatchTimestamp) {
        this.dispatchTimestamp = dispatchTimestamp;
    }

    /**
     * Returns the id of the contact set
     * 
     * @return Id of the contact set
     */
    public String getContactSetId() {
        return contactSetId;
    }

    /**
     * Sets the contact set id to the specified value
     * 
     * @param contactSetId
     *            Id of the contact set
     */
    public void setContactSetId(final String contactSetId) {
        this.contactSetId = contactSetId;
    }

    /**
     * Returns the operation number to which this object is associated to
     * 
     * @return Operation number
     */
    public Integer getOperationNumber() {
        return operationNumber;
    }

    /**
     * Sets the operation number to the provided value
     * 
     * @param operationNumber
     *            Operation number to which this object is related to
     */
    public void setOperationNumber(final Integer operationNumber) {
        this.operationNumber = operationNumber;
    }

    @Override
    public String toString() {
        return "ScheduleItem [contactSetId=" + contactSetId + ", dispatchTimestamp=" + dispatchTimestamp + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (contactSetId == null ? 0 : contactSetId.hashCode());
        result = prime * result + (int) (dispatchTimestamp ^ dispatchTimestamp >>> 32);
        result = prime * result + (operationNumber == null ? 0 : operationNumber.hashCode());
        return result;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof ScheduleItem)) {
            return false;
        }

        final ScheduleItem other = (ScheduleItem) obj;
        if (contactSetId == null && other.contactSetId != null) {
            return false;
        } else if (!contactSetId.equals(other.contactSetId)) {
            return false;
        }

        if (dispatchTimestamp != other.dispatchTimestamp) {
            return false;
        }

        if (operationNumber == null && other.operationNumber != null) {
            return false;
        } else if (!operationNumber.equals(other.operationNumber)) {
            return false;
        }
        return true;
    }

    @Override
    public int compareTo(final ScheduleItem o) {
        return Long.valueOf(dispatchTimestamp).compareTo(Long.valueOf(o.getDispatchTimestamp()));
    }

    /**
     * Static factory method to create a ScheduleItem object with the specified details.
     * 
     * @param contactSetId
     *            Contact set id
     * @param operationNumber
     *            Operation number to which the schedule item is related to
     * @param dispatchTimestamp
     *            Dispatch timestamp
     * @return ScheduleItem object
     */
    public static ScheduleItem create(final String contactSetId, final Integer operationNumber, final long dispatchTimestamp) {
        final ScheduleItem si = new ScheduleItem();
        si.setContactSetId(contactSetId);
        si.setOperationNumber(operationNumber);
        si.setDispatchTimestamp(dispatchTimestamp);
        return si;
    }
}
