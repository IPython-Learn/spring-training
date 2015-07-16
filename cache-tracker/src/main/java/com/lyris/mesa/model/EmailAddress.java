package com.lyris.mesa.model;

/**
 * This class defines the Email address attribute of the contact.
 * 
 * 
 * @author dnabi
 * @version 1.0, August 2013
 * 
 */
public class EmailAddress {

	private String email;
	public EMAIL_TYPE type;
	public EMAIL_STATE emailState;
	private boolean welcomeSent = false;
	private boolean primaryEmail = false;
	

	public enum EMAIL_TYPE {
		WORK, HOME, OTHER
	}

	public enum EMAIL_STATE {
		TRACKING_ONLY, TRANSACTION_READY, AWAITING_CONFIRMATION, PROMOTIONAL_READY, SOFT_BOUNCING, DEACTIVATED
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isWelcomeSent() {
		return welcomeSent;
	}

	public void setWelcomeSent(boolean welcomeSent) {
		this.welcomeSent = welcomeSent;
	}

	public boolean isPrimaryEmail() {
		return primaryEmail;
	}

	public void setPrimaryEmail(boolean primaryEmail) {
		this.primaryEmail = primaryEmail;
	}

	@Override
	public String toString() {
		return "EmailAddress [email=" + email + ", type=" + type
				+ ", emailState=" + emailState + ", welcomeSent=" + welcomeSent
				+ ", primaryEmail=" + primaryEmail + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result
				+ ((emailState == null) ? 0 : emailState.hashCode());
		result = prime * result + (primaryEmail ? 1231 : 1237);
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		result = prime * result + (welcomeSent ? 1231 : 1237);
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
		EmailAddress other = (EmailAddress) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (emailState != other.emailState)
			return false;
		if (primaryEmail != other.primaryEmail)
			return false;
		if (type != other.type)
			return false;
		if (welcomeSent != other.welcomeSent)
			return false;
		return true;
	}

	

}
