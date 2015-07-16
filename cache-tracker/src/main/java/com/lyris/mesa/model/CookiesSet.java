package com.lyris.mesa.model;

/**
 * This class defines the Cookie attribute of the contact.
 * 
 * @author dnabi
 * @version 1.0, August 2013
 */
public class CookiesSet {
	public enum COOKIE {
		ID, SET_DATE, EXPIRATION_DATE
	}

	private COOKIE cookie;

	public COOKIE getCookie() {
		return cookie;
	}

	public void setCookie(COOKIE cookie) {
		this.cookie = cookie;
	}

	@Override
	public String toString() {
		return "CookiesSet [cookie=" + cookie + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cookie == null) ? 0 : cookie.hashCode());
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
		CookiesSet other = (CookiesSet) obj;
		if (cookie != other.cookie)
			return false;
		return true;
	}

}
