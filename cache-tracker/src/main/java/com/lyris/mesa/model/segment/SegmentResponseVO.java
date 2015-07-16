package com.lyris.mesa.model.segment;

import java.io.Serializable;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * This class serves a dual purpose: it represents the object stored in the Hazelcast cache for all cached segments,
 * and it represents the object we return to the user. HOWEVER, the user should never see CacheId!!!
 * Therefore, the platform-edge SegmentService does not set cacheId.
 * @author nyakkala
 *
 * @author tvajjala
 */
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class SegmentResponseVO implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private String segmentId;

    private Integer lhqListId;

    private Audience audience;

    private CacheId cacheId;

    private int count;

    private String createDate;

    private String status;

    private String errorMessage;

    /**
     * @return the segmentId
     */
    public String getSegmentId() {
        return segmentId;
    }

    /**
     * @param id
     *            the id to set
     */
    public void setSegmentId(final String id) {
        this.segmentId = id;
    }

    /**
     * @return the audience
     */
    public Audience getAudience() {
        return audience;
    }

    /**
     * @param audience
     *            the audience to set
     */
    public void setAudience(final Audience audience) {
        this.audience = audience;
    }

    /**
     * @return the lhqListId
     */
    public Integer getLhqListId() {
        return lhqListId;
    }

    /**
     * @param lhqListId
     *            the lhqListId to set
     */
    public void setLhqListId(final Integer lhqListId) {
        this.lhqListId = lhqListId;
    }

    /**
     * @return the cacheId
     */
    public CacheId getCacheId() {
        return cacheId;
    }

    /**
     * @param cacheId
     *            the cacheId to set
     */
    public void setCacheId(final CacheId cacheId) {
        this.cacheId = cacheId;
    }

    /**
     * @return the count
     */
    public int getCount() {
        return count;
    }

    /**
     * @param count
     *            the count to set
     */
    public void setCount(final int count) {
        this.count = count;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status
     *            the status to set
     */
    public void setStatus(final String status) {
        this.status = status;
    }

    /**
     * @return the errorMessage
     */
    public String getErrorMessage() {
        return errorMessage;
    }

    /**
     * @param errorMessage
     *            the errorMessage to set
     */
    public void setErrorMessage(final String errorMessage) {
        this.errorMessage = errorMessage;
    }

    /**
     * @return the createDate
     */
    public String getCreateDate() {
        return createDate;
    }

    /**
     * @param createDate
     *            the createDate to set
     */
    public void setCreateDate(final String createDate) {
        this.createDate = createDate;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "SegmentResponseVO [id=" + segmentId + ", lhqListId=" + lhqListId + ", audience=" + audience + ", cacheId=" + cacheId + ", count=" + count
                + ", createDate=" + createDate + "]";
    }

}
