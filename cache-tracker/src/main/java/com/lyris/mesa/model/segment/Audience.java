package com.lyris.mesa.model.segment;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Generated;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.google.gson.annotations.Expose;

@Generated("org.jsonschema2pojo")
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class Audience implements Serializable {

    /**
	 * 
	 */
    private static final long serialVersionUID = 1723108777532180311L;

    /** Reference to lhqSegmentId */
    @Expose
    private Integer lhqSegmentId;

    /** Reference to the lhqSuppressionListIds */
    @Expose
    private List<Integer> lhqSuppressionListIds = new ArrayList<Integer>();

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
     * 
     * @return The lhqSuppressionListIds
     */
    public List<Integer> getLhqSuppressionListIds() {
        return lhqSuppressionListIds;
    }

    /**
     * 
     * @param lhqSuppressionListIds
     *            The lhqSuppressionListIds
     */
    public void setLhqSuppressionListIds(List<Integer> lhqSuppressionListIds) {
        this.lhqSuppressionListIds = lhqSuppressionListIds;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Audience [lhqSegmentId=" + lhqSegmentId + ", lhqSuppressionListIds=" + lhqSuppressionListIds
                + "]";
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(lhqSegmentId).append(lhqSuppressionListIds).toHashCode();
    }

    @Override
    public boolean equals(final Object other) {
        if (other == this) {
            return true;
        }
        if (other instanceof Audience == false) {
            return false;
        }
        final Audience rhs = (Audience) other;
        return new EqualsBuilder().append(lhqSegmentId, rhs.lhqSegmentId)
                .append(lhqSuppressionListIds, rhs.lhqSuppressionListIds).isEquals();
    }

}
