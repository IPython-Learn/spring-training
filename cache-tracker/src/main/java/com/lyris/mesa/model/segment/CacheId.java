package com.lyris.mesa.model.segment;

import java.io.Serializable;

import javax.annotation.Generated;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.google.gson.annotations.Expose;

@Generated("org.jsonschema2pojo")
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class CacheId implements Serializable {
	/** Default serial version UID */
	private static final long serialVersionUID = 1L;

	/** Reference to the hazelcast distributed map instance name */
    @Expose
    private String mapName;

    /** Reference to the key which is typically the cache id within the map */
    @Expose
    private String key;

    /**
     * Returns name of the hazelcast distributed map instance
     * 
     * @return Hazelcast map name
     */
    public String getMapName() {
        return mapName;
    }

    /**
     * Sets the hazelcast map name to the provided value
     * 
     * @param mapName
     *            Hazelcast map name
     */
    public void setMapName(final String mapName) {
        this.mapName = mapName;
    }

    /**
     * Returns the key within the hazelcast distributed map instance
     * 
     * @return key
     */
    public String getKey() {
        return key;
    }

    /**
     * Sets the key to the provided value
     * 
     * @param key
     *            Key
     */
    public void setKey(final String key) {
        this.key = key;
    }

    @Override
    public String toString() {
        return "CacheId [key=" + key + ", mapName=" + mapName + "]";
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(mapName).append(key).toHashCode();
    }

    @Override
    public boolean equals(final Object other) {
        if (other == this) {
            return true;
        }
        if (other instanceof CacheId == false) {
            return false;
        }
        final CacheId rhs = (CacheId) other;
        return new EqualsBuilder().append(mapName, rhs.mapName).append(key, rhs.key).isEquals();
    }

}
