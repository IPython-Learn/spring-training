package com.lyris.mesa.model.support;

import java.math.BigDecimal;

/**
 * This class allows to build a custom attribute for the contact. The type of
 * this custom attribute is BigDecimal.
 * 
 * @author dnabi
 * @Version 1.0, August 2013
 */
public class BigDecimalAttribute extends AbstractAttribute<BigDecimal> {

	private BigDecimal value;

	@Override
	public BigDecimal getValue() {
		return this.value;
	}

	@Override
	public void setValue(BigDecimal value) {
		this.value = value;
	}

}
