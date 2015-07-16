package com.lyris.mesa.model.support;

/**
 * This class allows to build a custom attribute for the contact. The type of
 * this custom attribute is Double.
 * 
 * @author dnabi
 * @version 1.0, August 2013
 */
public class DoubleAttribute extends AbstractAttribute<Double> {

	private Double value;

	@Override
	public Double getValue() {
		return this.value;
	}

	@Override
	public void setValue(Double value) {
		this.value = value;

	}

}
