package com.lyris.mesa.model.support;

/**
 * This abstract class allows to build different custom attributes for the
 * contact.
 * 
 * @author dnabi
 * 
 * @param <T>
 *            T can be String, Double, Boolean, Calendar, BigDecimal
 */
public abstract class AbstractAttribute<T extends Object> {
	
	protected String id;
	protected String label;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public abstract T getValue();

	public abstract void setValue(T value);

}
