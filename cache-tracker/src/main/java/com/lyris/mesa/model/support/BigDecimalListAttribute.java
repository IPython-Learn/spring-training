package com.lyris.mesa.model.support;

import java.math.BigDecimal;
import java.util.ArrayList;

/**
 * This class allows to build a list of custom attributes for the contact. The
 * type of these custom attributes is BigDecimal
 * 
 * @author dnabi
 * @version 1.0, August 2013
 */
public class BigDecimalListAttribute extends
		AbstractAttribute<ArrayList<BigDecimal>> {

	private ArrayList<BigDecimal> value;

	@Override
	public ArrayList<BigDecimal> getValue() {
		return this.value;
	}

	@Override
	public void setValue(ArrayList<BigDecimal> value) {
		this.value = value;
	}

}
