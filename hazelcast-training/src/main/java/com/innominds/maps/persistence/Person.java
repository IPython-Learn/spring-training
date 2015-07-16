package com.innominds.maps.persistence;

import java.io.Serializable;

public class Person implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7833487135008843190L;

	private String id;

	private String name;
	
	

	
	public String getId() {
		return id;
	}




	public void setId(String id) {
		this.id = id;
	}




	public String getName() {
		return name;
	}




	public void setName(String name) {
		this.name = name;
	}




	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + "]";
	}

}
