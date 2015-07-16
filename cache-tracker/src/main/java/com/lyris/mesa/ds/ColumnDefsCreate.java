package com.lyris.mesa.ds;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Generated;

import com.google.gson.annotations.Expose;

@Generated("org.jsonschema2pojo")
public class ColumnDefsCreate {

	@Expose
	private String name;
	@Expose
	private String meaningName;
	@Expose
	private String tableName;
	@Expose
	private String schemaName;
	@Expose
	Map<String, Object> properties = new HashMap<String, Object>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMeaningName() {
		return meaningName;
	}

	public void setMeaningName(String meaningName) {
		this.meaningName = meaningName;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getSchemaName() {
		return schemaName;
	}

	public void setSchemaName(String schemaName) {
		this.schemaName = schemaName;
	}

	public Map<String, Object> getProperties() {
		return properties;
	}

	public void setProperties(Map<String, Object> properties) {
		this.properties = properties;
	}
}