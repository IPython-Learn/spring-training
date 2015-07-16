package com.lyris.mesa.model.support;

import java.util.ArrayList;

/**
 * This class allows to build a list of custom attributes for the contact. The
 * type of these custom attributes is Boolean.
 * 
 * @author dnabi
 * @version 1.0, August 2013
 * 
 */

public class BooleanListAttribute extends AbstractAttribute<ArrayList<Boolean>> {

	private ArrayList<Boolean> value;

	@Override
	public ArrayList<Boolean> getValue() {
		return value;
	}

	@Override
	public void setValue(ArrayList<Boolean> value) {
		this.value = value;

	}

}
