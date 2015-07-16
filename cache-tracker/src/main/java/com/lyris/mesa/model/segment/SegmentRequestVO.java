package com.lyris.mesa.model.segment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.google.gson.annotations.Expose;

/**
 * SegmentRequestVO is in the common project so that it may be shared with other services. 
 * In addition, the corresponding SegmentResponseVO is stored in Hazelcast, so must be in common.
 *
 * Note that the Destination enum is different from com.lyris.mesa.model.segment.Destination.
 * This local destination class is what the API user sees; the Destination model class is used
 * by SegmentServiceRequest
 * 
 * This is generated from platform-edge /src/main/api/schema/segment-create.json
 */

@Generated("org.jsonschema2pojo")
public class SegmentRequestVO {

    /**
     * The segment identifier of a parent segment. If specified, the new segment will be created by starting with the parent segment
     * 
     */
    @Expose
    private String parentId;
    /**
     * Lyris HQ list identifier
     * (Required)
     * 
     */
    @Expose
    private int lhqListId;
    /**
     * Lyris HQ segment identifier
     * (Required)
     * 
     */
    @Expose
    private int lhqSegmentId;
    /**
     * Array of Lyris HQ suppression list identifiers
     * 
     */
    @Expose
    private List<Integer> lhqSuppressionListIds = new ArrayList<Integer>();
    /**
     * 
     * (Required)
     * 
     */
    @Expose
    private List<Destination> destination = new ArrayList<Destination>();


    /**
     * The segment identifier of a parent segment. If specified, the new segment will be created by starting with the parent segment
     * 
     * @return
     * The parentId
     */
    public String getParentId() {
        return parentId;
    }

    /**
     * The segment identifier of a parent segment. If specified, the new segment will be created by starting with the parent segment
     * 
     * @param parentId
     * The parentId
     */
    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    /**
     * Lyris HQ list identifier
     * (Required)
     * 
     * @return
     * The lhqListId
     */
    public int getLhqListId() {
        return lhqListId;
    }

    /**
     * Lyris HQ list identifier
     * (Required)
     * 
     * @param lhqListId
     * The lhqListId
     */
    public void setLhqListId(int lhqListId) {
        this.lhqListId = lhqListId;
    }

    /**
     * Lyris HQ segment identifier
     * (Required)
     * 
     * @return
     * The lhqSegmentId
     */
    public int getLhqSegmentId() {
        return lhqSegmentId;
    }

    /**
     * Lyris HQ segment identifier
     * (Required)
     * 
     * @param lhqSegmentId
     * The lhqSegmentId
     */
    public void setLhqSegmentId(int lhqSegmentId) {
        this.lhqSegmentId = lhqSegmentId;
    }

    /**
     * Array of Lyris HQ suppression list identifiers
     * 
     * @return
     * The lhqSuppressionListIds
     */
    public List<Integer> getLhqSuppressionListIds() {
        return lhqSuppressionListIds;
    }

    /**
     * Array of Lyris HQ suppression list identifiers
     * 
     * @param lhqSuppressionListIds
     * The lhqSuppressionListIds
     */
    public void setLhqSuppressionListIds(List<Integer> lhqSuppressionListIds) {
        this.lhqSuppressionListIds = lhqSuppressionListIds;
    }

    /**
     * 
     * (Required)
     * 
     * @return
     * The destination
     */
    public List<Destination> getDestination() {
        return destination;
    }

    /**
     * 
     * (Required)
     * 
     * @param destination
     * The destination
     */
    public void setDestination(List<Destination> destination) {
        this.destination = destination;
    }

    public enum Destination {

        LHQ("lhq"), SEGMENT_ID("segmentId"), COUNT("count");
        private final String value;
        private static Map<String, Destination> constants = new HashMap<String, Destination>();

        static {
            for (Destination c : values()) {
                constants.put(c.value, c);
            }
        }

        private Destination(String value) {
            this.value = value;
        }

        @Override
        @JsonValue
        public String toString() {
            return this.value;
        }

        @JsonCreator
        public static Destination fromValue(String value) {
            Destination constant = constants.get(value);
            if (constant == null) {
                throw new IllegalArgumentException(value);
            } else {
                return constant;
            }
        }

    }
}