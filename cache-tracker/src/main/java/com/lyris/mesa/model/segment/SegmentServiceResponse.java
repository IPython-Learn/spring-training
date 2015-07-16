package com.lyris.mesa.model.segment;

import javax.annotation.Generated;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.google.gson.annotations.Expose;

@Generated("org.jsonschema2pojo")
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class SegmentServiceResponse {
    /** Reference to the lhq segment id */
    @Expose
    private Integer lhqSegmentId;

    /** Reference to the CacheId object that holds the key and name of the hazelcast distributed map instance */
    @Expose
    private CacheId cacheId;

    /** Reference to the count of contacts */
    @Expose
    private Integer count;

    /** Reference to a boolean indicating if the request was successful (Required) */
    @Expose
    private Boolean success;

    /** Holds the errors if the request processing failed */
    @Expose
    private String errors;

    /**
     * Returns LHQ segment id
     * 
     * @return LHQ segment id
     */
    public Integer getLhqSegmentId() {
        return lhqSegmentId;
    }

    /**
     * Sets the LHQ segment id to the provided value
     * 
     * @param lhqSegmentId
     *            LHQ segment id
     */
    public void setLhqSegmentId(final Integer lhqSegmentId) {
        this.lhqSegmentId = lhqSegmentId;
    }

    /**
     * Returns the CacheId object
     * 
     * @return CacheId object that holds the key and the name of the hazelcast distributed map instance
     */
    public CacheId getCacheId() {
        return cacheId;
    }

    /**
     * Sets the CacheId to the provided value
     * 
     * @param cacheId
     *            CacheId object holding the key and the name of the hazelcast distributed map instance
     */
    public void setCacheId(final CacheId cacheId) {
        this.cacheId = cacheId;
    }

    /**
     * Returns the count of contacts
     * 
     * @return Count of contacts
     */
    public Integer getCount() {
        return count;
    }

    /**
     * Sets the count of contacts to the provided value
     * 
     * @param count
     *            Count of contacts
     */
    public void setCount(final Integer count) {
        this.count = count;
    }

    /**
     * Indicates if the request was successful (Required)
     * 
     * @return true if the request was successful
     */
    public Boolean getSuccess() {
        return success;
    }

    /**
     * Sets the provided value to the success field of this class.
     * 
     * @param success
     *            Boolean indicating if the request processing was successful
     */
    public void setSuccess(final Boolean success) {
        this.success = success;
    }

    /**
     * Returns the errors in case the request processing failed
     * 
     * @return Error message
     */
    public String getErrors() {
        return errors;
    }

    /**
     * Sets the errors to the provided value
     * 
     * @param errors
     *            Error message
     */
    public void setErrors(final String errors) {
        this.errors = errors;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        // TODO: I believe that we don't need to rely on success & errorMessage to compare if 2 SegmentResponse objects are equal? Hence not using them in
        // comparison
        return new HashCodeBuilder().append(lhqSegmentId).append(cacheId).append(count).toHashCode();
    }

    @Override
    public boolean equals(final Object other) {
        if (other == this) {
            return true;
        }
        if (other instanceof SegmentServiceResponse == false) {
            return false;
        }
        final SegmentServiceResponse rhs = (SegmentServiceResponse) other;
        // TODO: I believe that we don't need to rely on success & errorMessage to compare if 2 SegmentResponse objects are equal? Hence not using them in
        // comparison
        return new EqualsBuilder().append(lhqSegmentId, rhs.lhqSegmentId).append(cacheId, rhs.cacheId).append(count, rhs.count).isEquals();
    }

}
