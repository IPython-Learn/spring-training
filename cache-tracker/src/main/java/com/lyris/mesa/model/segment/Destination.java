package com.lyris.mesa.model.segment;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public enum Destination {

	@SerializedName("lhq")
    LHQ("lhq"), 
    @SerializedName("cacheId")
    CACHE_ID("cacheId"), 
    @SerializedName("count")
    COUNT("count");

    /** value for the enum constant */
    private final String value;
    /** Map to hold the mapings */
    private static Map<String, Destination> constants = new HashMap<String, Destination>();

    static {
        for (final Destination c : values()) {
            Destination.constants.put(c.value, c);
        }
    }

    private Destination(final String value) {
        this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
        return value;
    }

    @JsonCreator
    public static Destination fromValue(final String value) {
        final Destination constant = Destination.constants.get(value);
        if (constant == null) {
            throw new IllegalArgumentException(value);
        } else {
            return constant;
        }
    }
}
