package com.lyris.mesa.model;

/**
 * This class defines the Telephone number attribute of the contact.
 * 
 * @author dnabi
 * @version 1.0, August 2013
 */
public class TelephoneNumber {

	private String number;
	private String countryCode;
	private String extension;
	private PHONE_NUMBER_TYPE type;

	public enum PHONE_NUMBER_TYPE {
		WORK, HOME, CELL, FAX, OTHER
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getExtension() {
		return extension;
	}

	public void setExtension(String extension) {
		this.extension = extension;
	}

	public PHONE_NUMBER_TYPE getType() {
		return type;
	}

	public void setType(PHONE_NUMBER_TYPE type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "TelephoneNumber [number=" + number + ", countryCode="
				+ countryCode + ", extension=" + extension + ", type=" + type
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((countryCode == null) ? 0 : countryCode.hashCode());
		result = prime * result
				+ ((extension == null) ? 0 : extension.hashCode());
		result = prime * result + ((number == null) ? 0 : number.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		TelephoneNumber other = (TelephoneNumber) obj;
		if (countryCode == null) {
			if (other.countryCode != null)
				return false;
		} else if (!countryCode.equals(other.countryCode))
			return false;
		if (extension == null) {
			if (other.extension != null)
				return false;
		} else if (!extension.equals(other.extension))
			return false;
		if (number == null) {
			if (other.number != null)
				return false;
		} else if (!number.equals(other.number))
			return false;
		if (type != other.type)
			return false;
		return true;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

}
