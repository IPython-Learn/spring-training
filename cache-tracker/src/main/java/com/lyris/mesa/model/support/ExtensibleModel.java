package com.lyris.mesa.model.support;

import java.util.Calendar;
import java.util.HashMap;

/**
 * This class is the parent of canonical model objects like contact and
 * Organization
 * 
 * @author dnabi
 * @version 1.0, August 2013
 * 
 */
public class ExtensibleModel {

	private String id;
	private Calendar creationDate;
	private HashMap<String, ObjectAttribute> attributes = new HashMap<String, ObjectAttribute>();

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((attributes == null) ? 0 : attributes.hashCode());
		result = prime * result
				+ ((creationDate == null) ? 0 : creationDate.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ExtensibleModel other = (ExtensibleModel) obj;
		if (attributes == null) {
			if (other.attributes != null)
				return false;
		} else if (!attributes.equals(other.attributes))
			return false;
		if (creationDate == null) {
			if (other.creationDate != null)
				return false;
		} else if (!creationDate.equals(other.creationDate))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ExtensibleModel [id=" + id + ", creationDate=" + creationDate
				+ ", attributes=" + attributes + "]";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public HashMap<String, ObjectAttribute> getAttributes() {
		return attributes;
	}

	public void setAttributes(HashMap<String, ObjectAttribute> attributes) {
		this.attributes = attributes;
	}

	public Calendar getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Calendar creationDate) {
		this.creationDate = creationDate;
	}

}
