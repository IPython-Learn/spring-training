package com.lyris.mesa.sync;

import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

import javax.annotation.Generated;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.google.gson.annotations.Expose;

/**
 * Synchronization specification between two data sources
 * 
 */
@Generated("org.jsonschema2pojo")
@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
public class Sync {
    
	@Expose
	private String version;
    @Expose
    private String id;
    @Expose
    private String orgName;
    @Expose
    private DataStore source1;
    @Expose
    private DataStore source2;
    @Expose
    private LinkedHashSet<Mapping> mapping;
    @Expose
    private LinkedHashSet<Mapping> mappingOptOut;
    @Expose
    private Date start;
    @Expose
    private Date end;
    @Expose
    private Integer repeatInterval;
    @Expose
    private Date priorSyncStartTime;
    @Expose
    private Date nextScheduledTime;
    @Expose
    private Boolean propagateInserts;
    @Expose
    private Boolean propagateUpdates;
    @Expose
    private Boolean propagateDeletes;
    @Expose
    private Boolean propagateNulls;
    @Expose
    private Boolean overrideNulls;
    @Expose
    private Boolean overrideExisting;    
    @Expose
    private String status;
    @Expose
    private Date lastUpdate;
    @Expose
    private Integer rowTotal;
    @Expose
    private Integer rowsRead;
    @Expose
    private Integer rowsInserted; 
    @Expose
    private Integer rowsUpdated; 
    @Expose
    private Integer rowsInvalid;
    @Expose
    private Integer cumulativeRowTotal;
    @Expose
    private Integer cumulativeRowsRead;
    @Expose
    private Integer cumulativeRowsInserted; 
    @Expose
    private Integer cumulativeRowsUpdated; 
    @Expose
    private Integer cumulativeRowsInvalid;
    @Expose
    private String syncJobStatusId;
    @Expose
    private String errorReportFile;
    @Expose
    private String errorInfo;
    
    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }
    
    public DataStore getSource1() {
        return source1;
    }

    public void setSource1(DataStore source1) {
        this.source1 = source1;
    }

    public DataStore getSource2() {
        return source2;
    }

    public void setSource2(DataStore source2) {
        this.source2 = source2;
    }
    
    public LinkedHashSet<Mapping> getMapping() {
        return mapping;
    }

    public void setMapping(LinkedHashSet<Mapping> mapping) {
        this.mapping = mapping;
    }
    
    public LinkedHashSet<Mapping> getMappingOptOut() {
        return mappingOptOut;
    }

    public void setMappingOptOut(LinkedHashSet<Mapping> mappingOptOut) {
        this.mappingOptOut = mappingOptOut;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public Integer getRepeatInterval() {
        return repeatInterval;
    }

    public void setRepeatInterval(Integer repeatInterval) {
        this.repeatInterval = repeatInterval;
    }
    
    public Date getPriorSyncStartTime() {
        return priorSyncStartTime;
    }
    
    public void setPriorSyncStartTime(Date priorSyncStartTime) {
        this.priorSyncStartTime = priorSyncStartTime;
    }
    
    public Date getNextScheduledTime() {
        return nextScheduledTime;
    }
    
    public void setNextScheduledTime(Date nextScheduledTime) {
        this.nextScheduledTime = nextScheduledTime;
    }
    
    public Boolean getPropagateInserts() {
        return propagateInserts;
    }

    public void setPropagateInserts(Boolean propagateInserts) {
        this.propagateInserts = propagateInserts;
    }

    public Boolean getPropagateUpdates() {
        return propagateUpdates;
    }

    public void setPropagateUpdates(Boolean propagateUpdates) {
        this.propagateUpdates = propagateUpdates;
    }
    
    public Boolean getPropagateDeletes() {
        return propagateDeletes;
    }

    public void setPropagateDeletes(Boolean propagateDeletes) {
        this.propagateDeletes = propagateDeletes;
    }

    public Boolean getPropagateNulls() {
        return propagateNulls;
    }

    public void setPropagateNulls(Boolean propagateNulls) {
        this.propagateNulls = propagateNulls;
    }

    public Boolean getOverrideNulls() {
        return overrideNulls;
    }

    public void setOverrideNulls(Boolean overrideNulls) {
        this.overrideNulls = overrideNulls;
    }

    public Boolean getOverrideExisting() {
        return overrideExisting;
    }

    public void setOverrideExisting(Boolean overrideExisting) {
        this.overrideExisting = overrideExisting;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) { 
        if(StringUtils.isNotBlank(status)) {
            this.status = Sync.Status.fromValue(status).toString();
        }
    }



    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public Integer getRowTotal() {
        return rowTotal;
    }

    public void setRowTotal(Integer rowTotal) {
        this.rowTotal = rowTotal;
    }

    public Integer getRowsRead() {
        return rowsRead;
    }

    public void setRowsRead(Integer rowsRead) {
        this.rowsRead = rowsRead;
    }

    public Integer getRowsInserted() {
        return rowsInserted;
    }

    public void setRowsInserted(Integer rowsInserted) {
        this.rowsInserted = rowsInserted;
    }

    public Integer getRowsUpdated() {
        return rowsUpdated;
    }

    public void setRowsUpdated(Integer rowsUpdated) {
        this.rowsUpdated = rowsUpdated;
    }

    public Integer getRowsInvalid() {
        return rowsInvalid;
    }

    public void setRowsInvalid(Integer rowsInvalid) {
        this.rowsInvalid = rowsInvalid;
    }
    public Integer getCumulativeRowTotal() {
        return cumulativeRowTotal;
    }

    public void setCumulativeRowTotal(Integer cumulativeRowTotal) {
        this.cumulativeRowTotal = cumulativeRowTotal;
    }

    public Integer getCumulativeRowsRead() {
        return cumulativeRowsRead;
    }

    public void setCumulativeRowsRead(Integer cumulativeRowsRead) {
        this.cumulativeRowsRead = cumulativeRowsRead;
    }

    public Integer getCumulativeRowsInserted() {
        return cumulativeRowsInserted;
    }

    public void setCumulativeRowsInserted(Integer cumulativeRowsInserted) {
        this.cumulativeRowsInserted = cumulativeRowsInserted;
    }

    public Integer getCumulativeRowsUpdated() {
        return cumulativeRowsUpdated;
    }

    public void setCumulativeRowsUpdated(Integer cumulativeRowsUpdated) {
        this.cumulativeRowsUpdated = cumulativeRowsUpdated;
    }

    public Integer getCumulativeRowsInvalid() {
        return cumulativeRowsInvalid;
    }

    public void setCumulativeRowsInvalid(Integer cumulativeRowsInvalid) {
        this.cumulativeRowsInvalid = cumulativeRowsInvalid;
    }

    public String getSyncJobStatusId() {
        return syncJobStatusId;
    }

    public void setSyncJobStatusId(String syncJobStatusId) {
        this.syncJobStatusId = syncJobStatusId;
    }

    public String getErrorReportFile() {
        return errorReportFile;
    }

    public void setErrorReportFile(String errorReportFile) {
        this.errorReportFile = errorReportFile;
    }

    public String getErrorInfo() {
        return errorInfo;
    }

    public void setErrorInfo(String errorInfo) {
        this.errorInfo = errorInfo;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }

    @Override
    public boolean equals(Object other) {
        return EqualsBuilder.reflectionEquals(this, other);
    }


    @Generated("org.jsonschema2pojo")
    public static enum Status {

    	SAVED("saved"), READY("ready"), RUNNING("running"), STOPPED("stopped"), PAUSED("paused"), DONE("done"), ABORTED("aborted"), DELETED("deleted");
        private final String value;
        private static Map<String, Sync.Status> constants = new HashMap<String, Sync.Status>();

        static {
            for (Sync.Status c : Sync.Status.values()) 
                constants.put(c.value, c);
        }

        private Status(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return this.value;
        }

        public static Sync.Status fromValue(String value) {
            Sync.Status constant = constants.get(value);
            if (constant == null) 
                throw new IllegalArgumentException(value);
            else 
                return constant;
        }

    }
    
    public boolean compareIgnoreStatus(Object other) {
        return EqualsBuilder.reflectionEquals(this, other, new String[] {"status", "lastUpdate"});        
    }

}