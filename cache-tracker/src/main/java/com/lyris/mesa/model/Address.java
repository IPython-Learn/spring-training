package com.lyris.mesa.model;

/**
 * This class defines the address attribute of the contact.
 * 
 * @author dnabi
 * @version 1.0, August 2013
 */

public class Address {

	private String streetLine1;

	private String streetLine2;
	private String streetLine3;
	private String city;
	private String stateOrProvince;
	private String zip;
	private String country;
	private ADDRESS_TYPE addressType;

	public enum ADDRESS_TYPE {
		HOME, WORK, BILLING, SHIPPING, OTHER
	}

	@Override
	public String toString() {
		return "Address [streetLine1=" + streetLine1 + ", streetLine2="
				+ streetLine2 + ", streetLine3=" + streetLine3 + ", city="
				+ city + ", stateOrProvince=" + stateOrProvince + ", zip="
				+ zip + ", country=" + country + ", addressType=" + addressType
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((addressType == null) ? 0 : addressType.hashCode());
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((country == null) ? 0 : country.hashCode());
		result = prime * result
				+ ((stateOrProvince == null) ? 0 : stateOrProvince.hashCode());
		result = prime * result
				+ ((streetLine1 == null) ? 0 : streetLine1.hashCode());
		result = prime * result
				+ ((streetLine2 == null) ? 0 : streetLine2.hashCode());
		result = prime * result
				+ ((streetLine3 == null) ? 0 : streetLine3.hashCode());
		result = prime * result + ((zip == null) ? 0 : zip.hashCode());
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
		Address other = (Address) obj;
		if (addressType != other.addressType)
			return false;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (country == null) {
			if (other.country != null)
				return false;
		} else if (!country.equals(other.country))
			return false;
		if (stateOrProvince == null) {
			if (other.stateOrProvince != null)
				return false;
		} else if (!stateOrProvince.equals(other.stateOrProvince))
			return false;
		if (streetLine1 == null) {
			if (other.streetLine1 != null)
				return false;
		} else if (!streetLine1.equals(other.streetLine1))
			return false;
		if (streetLine2 == null) {
			if (other.streetLine2 != null)
				return false;
		} else if (!streetLine2.equals(other.streetLine2))
			return false;
		if (streetLine3 == null) {
			if (other.streetLine3 != null)
				return false;
		} else if (!streetLine3.equals(other.streetLine3))
			return false;
		if (zip == null) {
			if (other.zip != null)
				return false;
		} else if (!zip.equals(other.zip))
			return false;
		return true;
	}

	public String getStreetLine1() {
		return streetLine1;
	}

	public void setStreetLine1(String streetLine1) {
		this.streetLine1 = streetLine1;
	}

	public String getStreetLine2() {
		return streetLine2;
	}

	public void setStreetLine2(String streetLine2) {
		this.streetLine2 = streetLine2;
	}

	public String getStreetLine3() {
		return streetLine3;
	}

	public void setStreetLine3(String streetLine3) {
		this.streetLine3 = streetLine3;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStateOrProvince() {
		return stateOrProvince;
	}

	public void setStateOrProvince(String stateOrProvince) {
		this.stateOrProvince = stateOrProvince;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public ADDRESS_TYPE getAddressType() {
		return addressType;
	}

	public void setAddressType(ADDRESS_TYPE addressType) {
		this.addressType = addressType;
	}

}
