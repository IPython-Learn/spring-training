package com.lyris.mesa.sync;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.google.gson.annotations.Expose;

@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
public class Mapping {

    @Expose
    private String source1Attribute;
    @Expose
    private String source2Attribute;
    @Expose 
    private String target;

    public String getSource1Attribute() {
        return source1Attribute;
    }

    public void setSource1Attribute(String source1Attribute) {
        this.source1Attribute = source1Attribute;
    }

    public String getSource2Attribute() {
        return source2Attribute;
    }

    public void setSource2Attribute(String source2Attribute) {
        this.source2Attribute = source2Attribute;
    }
    
    public String getTarget() {
    	return this.target;
    }
    
    @JsonSerialize(include=JsonSerialize.Inclusion.ALWAYS)
    public void setTarget(String target) { 
    	if(StringUtils.isNotBlank(target)) {
    		this.target = Target.fromValue(target).toString();
    	} else {
    		this.target = null; //target not yet set
    	}
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
    
	public static enum Target {

		SOURCE1("source1"), SOURCE2("source2"), BIDIRECTIONAL("bidirectional");
		private final String value;
		private static Map<String, Target> constants = new HashMap<String, Target>();

		static {
			for (Target c : Target.values())
				constants.put(c.value, c);
		}

		private Target(String value) {
			this.value = value;
		}

		@Override
		public String toString() {
			return this.value;
		}

		public static Target fromValue(String value) {
			Target constant = constants.get(value);
			if (constant == null)
				throw new IllegalArgumentException(value);
			else
				return constant;
		}
	}

}
