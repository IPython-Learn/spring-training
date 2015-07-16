package com.lyris.mesa.ds;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;

@Generated("org.jsonschema2pojo")
public class SchemaUploadDefs {

	@Expose
	private List<MeaningDefsRegister> meaningDefsRegister = new ArrayList<MeaningDefsRegister>();
	@Expose
	private List<ColumnDefsCreate> columnDefsCreate = new ArrayList<ColumnDefsCreate>();
	@Expose
	private List<ColumnDefsRegister> columnDefsRegister = new ArrayList<ColumnDefsRegister>();

	public List<MeaningDefsRegister> getMeaningDefsRegister() {
		return meaningDefsRegister;
	}

	public void setMeaningDefsRegister(
			List<MeaningDefsRegister> meaningDefsRegister) {
		this.meaningDefsRegister = meaningDefsRegister;
	}

	public List<ColumnDefsCreate> getColumnDefsCreate() {
		return columnDefsCreate;
	}

	public void setColumnDefsCreate(List<ColumnDefsCreate> columnDefsCreate) {
		this.columnDefsCreate = columnDefsCreate;
	}

	public List<ColumnDefsRegister> getColumnDefsRegister() {
		return columnDefsRegister;
	}

	public void setColumnDefsRegister(List<ColumnDefsRegister> columnDefsRegister) {
		this.columnDefsRegister = columnDefsRegister;
	}
}