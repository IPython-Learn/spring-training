package com.lyris.mesa.model.support;

import java.util.Calendar;

/**
 * This class allows to build a custom attribute for the contact. The type of
 * this attribute is Calendar.
 * 
 * @author dnabi
 * @version 1.0, August 2013
 */
public class CalendarAttribute extends AbstractAttribute<Calendar> {

	private Calendar value;

	@Override
	public Calendar getValue() {
		return this.value;
	}

	@Override
	public void setValue(Calendar value) {
		this.value = value;

	}

}
