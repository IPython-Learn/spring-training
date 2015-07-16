package com.lyris.mesa.model.support;

/**
 * This class allows to build a custom attribute for the contact. The type of
 * this custom attribute is Boolean.
 * 
 * @author dnabi
 * @version 1.0, August 2013
 */

public class BooleanAttribute extends AbstractAttribute<Boolean> {

	private Boolean value;

	@Override
	public Boolean getValue() {
		return this.value;
	}

	@Override
	public void setValue(Boolean value) {
		this.value = value;

	}

}
