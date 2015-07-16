package com.lyris.mesa.model.segment;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Generated;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.google.gson.annotations.Expose;

@Generated("org.jsonschema2pojo")
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class SegmentServiceRequest {

    /** Reference to the transaction name/ID invoking this request (optional, used for logging) */
    @Expose
    private String transactionId;

    /** Reference to the org name (Required) */
    @Expose
    private String orgName;

    /** Reference to the LHQ farm URL */
    @Expose
    private String farmUrl;

    /** Reference to the CacheId object */
    @Expose
    private CacheId cacheId;

    /** Reference to the Audience object (Required) */
    @Expose
    private Audience audience;

    /** Reference to the list of destinations (Required) */
    @Expose
    private List<Destination> destination = new ArrayList<Destination>();

    /**
     * @return the transactionId
     */
    public String getTransactionId() {
        return transactionId;
    }

    /**
     * @param transactionId the transactionId to set
     */
    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    /**
     * Returns the organization name
     * 
     * @return Organization name
     */
    public String getOrgName() {
        return orgName;
    }

    /**
     * Sets the organization name to the provided value
     * 
     * @param orgName
     *            Name of the organization to set
     */
    public void setOrgName(final String orgName) {
        this.orgName = orgName;
    }

    /**
     * @return the farmUrl
     */
    public String getFarmUrl() {
        return farmUrl;
    }

    /**
     * @param farmUrl the farmUrl to set
     */
    public void setFarmUrl(String farmUrl) {
        this.farmUrl = farmUrl;
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
     * Returns the Audience object
     * 
     * @return Audience object containing the segment id and suppression list id
     */
    public Audience getAudience() {
        return audience;
    }

    /**
     * Sets the Audience object to the provided value
     * 
     * @param audience
     *            Audience object containing the segment id and suppression list id
     */
    public void setAudience(final Audience audience) {
        this.audience = audience;
    }

    /**
     * Returns the Destination object
     * 
     * @return Destination object
     */
    public List<Destination> getDestination() {
        return destination;
    }

    /**
     * Sets the Destination object to the provided value
     * 
     * @param destination
     *            Destination object
     */
    public void setDestination(final List<Destination> destination) {
        this.destination = destination;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        // No need to include farmUrl in hashcode, orgName : cacheId : audience is unique
        return new HashCodeBuilder().append(orgName).append(cacheId).append(audience).toHashCode();
    }

    @Override
    public boolean equals(final Object other) {
        if (other == this) {
            return true;
        }
        if (other instanceof SegmentServiceRequest == false) {
            return false;
        }
        final SegmentServiceRequest rhs = (SegmentServiceRequest) other;
        return new EqualsBuilder().append(orgName, rhs.orgName).append(farmUrl, rhs.farmUrl)
                .append(cacheId, rhs.cacheId).append(audience, rhs.audience)
                .append(destination, rhs.destination).isEquals();
    }

}
