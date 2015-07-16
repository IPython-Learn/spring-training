package com.lyris.mesa.model;

/**
 * This class defines the Social handle attribute of the contact.
 * 
 * @author dnabi
 * @version 1.0, August 2013
 */
public class SocialHandle {

	private SOCIAL_HANDLE_TYPE socialHandlesType;

	public enum SOCIAL_HANDLE_TYPE {
		FACEBOOK, TWITTER, PINTEREST, OTHER
	}

	public SOCIAL_HANDLE_TYPE getSocialHandlesType() {
		return socialHandlesType;
	}

	public void setSocialHandlesType(SOCIAL_HANDLE_TYPE socialHandlesType) {
		this.socialHandlesType = socialHandlesType;
	}

	@Override
	public String toString() {
		return "SocialHandles [socialHandlesType=" + socialHandlesType + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((socialHandlesType == null) ? 0 : socialHandlesType
						.hashCode());
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
		SocialHandle other = (SocialHandle) obj;
		if (socialHandlesType != other.socialHandlesType)
			return false;
		return true;
	}

}
