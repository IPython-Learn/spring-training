package com.lyris.mesa.model.support;

import java.util.ArrayList;

/**
 * This class allows to build a list of custom attributes for the contact. The
 * type of these custom attributes is String.
 * 
 * @author dnabi
 * @version 1.0, August 2013
 */
public class StringListAttribute extends AbstractAttribute<ArrayList<String>> {

	private ArrayList<String> value;

	@Override
	public ArrayList<String> getValue() {
		return this.value;
	}

	@Override
	public void setValue(ArrayList<String> value) {
		this.value = value;
	}

}
