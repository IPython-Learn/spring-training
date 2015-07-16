package com.lyris.mesa.sync;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
public class SalesforceConnect {

    private String tableName;
    
    public static enum SalesforceTable {
        CONTACT("Contact"), LEADS("Leads");        
        private final String value;        
        private static Map<String, SalesforceTable> constants = new HashMap<String, SalesforceTable>();

        static {
            for (SalesforceTable c : SalesforceTable.values())
                constants.put(c.value, c);
        }

        private SalesforceTable(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return this.value;
        }
        
        public static SalesforceTable fromValue(String value) {
            SalesforceTable constant = constants.get(value);
            if (constant == null) 
                throw new IllegalArgumentException(value + " is not a valid Salesforce table name, must be \"Contact\" or \"Leads\"");
            else 
                return constant;
        }
    }

    public String getTableName() {
        return this.tableName;
    }

    public void setTableName(String tableName) {
        if (SalesforceTable.fromValue(tableName) != null)
            this.tableName = tableName;
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

}
