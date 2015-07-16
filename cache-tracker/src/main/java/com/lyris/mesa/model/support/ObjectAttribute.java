package com.lyris.mesa.model.support;

public class ObjectAttribute extends AbstractAttribute<Object> {
	
	private Object value;
	
	@Override
	public Object getValue() {
		return this.value;
	}

	@Override
	public void setValue(Object value) {
		this.value = value;
	}

}
