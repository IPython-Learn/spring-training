package com.lyris.mesa.model.support;

/**
 * This class allows to build a custom attribute for the contact. The type of
 * this custom attribute is String.
 * 
 * @author dnabi
 * @version 1.0, August 2013
 */
public class StringAttribute extends AbstractAttribute<String> {

	private String value;

	@Override
	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}