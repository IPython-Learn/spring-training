package com.lyris.mesa.ds;

/**
 * Java representation of a ds.column.create request, properties section. JSON looks like this:
 *{
 *   "name": "Contact Id",
 *   "orgName": "org1",
 *   "schemaName": "schema1",
 *   "tableName": "Contact",
 *   "meaningName": "Unique contact identifier",
 *   "properties": {
 *     "primaryKey": false,
 *     "unique": true,
 *     "nullable": true,
 *     "columnType":"INT"
 *   }
 * }
 * @author tchilders
 *
 */

public class ColumnCreateProperties {

    private ColumnType columnType;
    private Boolean primaryKey;
    private Boolean unique;
    private Boolean nullable;
    private String defaultValue;
    private Long maxValue;
    private Long precision;

	public static enum ColumnType {
        VARCHAR("VARCHAR"), 
        TEXT("TEXT"), 
        INT("INT"),
        BIGINT("BIGINT"),
        DATE("DATE"),
        DOUBLE("DOUBLE"),
        FLOAT("FLOAT"),
        DECIMAL("DECIMAL"),
        BLOB("BLOB"),
        TIMESTAMP("TIMESTAMP");
        
        private final String value;
        
        private ColumnType (String value) {
            this.value = value;
        }
        
        public String getValue() {
            return value;
        }
        
        public String getName() {
            return name().toLowerCase();
        }
        
        public static ColumnType getType(Object value) {
            for (ColumnType s: values()) {
                if (s.getName().equalsIgnoreCase((String) value))
                    return s;
            }
            return null;
        }
    }

    public ColumnCreateProperties() {
        super();
    }

    public ColumnType getColumnType() {
        return columnType;
    }

    public void setColumnType(ColumnType columnType) {
        this.columnType = columnType;
    }

    public Boolean isPrimaryKey() {
        return primaryKey;
    }

    public void setPrimaryKey(boolean isPrimaryKey) {
        this.primaryKey = isPrimaryKey;
    }

    public Boolean isUnique() {
        return unique;
    }

    public void setUnique(boolean unique) {
        this.unique = unique;
    }

    public Boolean isNullable() {
        return nullable;
    }

    public void setNullable(boolean nullable) {
        this.nullable = nullable;
    }

    public String getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
    }

    public Long getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(Long maxValue) {
        this.maxValue = maxValue;
    }
    

    public Long getPrecision() {
		return precision;
	}

	public void setPrecision(Long precision) {
		this.precision = precision;
	}

}
