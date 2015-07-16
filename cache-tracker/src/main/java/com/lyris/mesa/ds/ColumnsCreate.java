package com.lyris.mesa.ds;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Generated;

import com.google.gson.annotations.Expose;

@Generated("org.jsonschema2pojo")
public class ColumnsCreate {

	@Expose
	private List<ColumnCreate> attributes = new ArrayList<ColumnCreate>();

	public List<ColumnCreate> getAttributes() {
		return attributes;
	}

	public void setAttributes(List<ColumnCreate> attributes) {
		this.attributes = attributes;
	}
	
}