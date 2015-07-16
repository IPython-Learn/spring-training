package com.lyris.mesa.model.support;

import java.util.ArrayList;
import java.util.Calendar;

/**
 * This class allows to build a list of custom attributes for the contact. The
 * type of these custom attribute is Calendar.
 * 
 * @author dnabi
 * @version 1.0, August 2013
 */
public class CalendarListAttribute extends
		AbstractAttribute<ArrayList<Calendar>> {

	private ArrayList<Calendar> value;

	@Override
	public ArrayList<Calendar> getValue() {
		return this.value;
	}

	@Override
	public void setValue(ArrayList<Calendar> value) {
		this.value = value;
	}

}
