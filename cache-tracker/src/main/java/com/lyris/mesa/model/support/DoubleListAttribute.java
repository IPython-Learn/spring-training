package com.lyris.mesa.model.support;

import java.util.ArrayList;

/**
 * This class allows to build a list of custom attributes for the contact. The
 * type of these custom attributes is Double.
 * 
 * @author dnabi
 * @version 1.0, August 2013
 */
public class DoubleListAttribute extends AbstractAttribute<ArrayList<Double>> {

	private ArrayList<Double> value;

	@Override
	public ArrayList<Double> getValue() {
		return this.value;
	}

	@Override
	public void setValue(ArrayList<Double> value) {
		this.value = value;
	}

}
