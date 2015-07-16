package com.lyris.mesa.ds;


/**
 * Java representation of a ds.column.create request. JSON looks like this:
 *{
 *   "name": "Contact Id",
 *   "orgName": "org1",
 *   "schemaName": "schema1",
 *   "tableName": "table1",
 *   "meaningName": "String",
 *   "properties": {
 *     "unique": true,
 *     "nullable": true,
 *     "columnType":"INT"
 *   }
 * }
 * @author tchilders
 *
 */
public class ColumnCreate {

    private String name;
    private String schemaName;
    private String tableName;
    private String meaningName;
    private ColumnCreateProperties properties;

    public ColumnCreate() {

        super();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSchemaName() {
        return schemaName;
    }

    public void setSchemaName(String schemaName) {
        this.schemaName = schemaName;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getMeaningName() {
        return meaningName;
    }

    public void setMeaningName(String meaningName) {
        this.meaningName = meaningName;
    }

    public ColumnCreateProperties getProperties() {
        return properties;
    }

    public void setProperties(ColumnCreateProperties properties) {
        this.properties = properties;
    }

}
