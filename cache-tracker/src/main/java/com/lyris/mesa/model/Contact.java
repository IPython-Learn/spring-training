package com.lyris.mesa.model;

import java.util.ArrayList;
import java.util.Calendar;

import com.lyris.mesa.model.support.ExtensibleModel;

/**
 * This class defines a canonical model of a contact object.
 * 
 * @author dnabi
 * @version 1.0, August 2013
 * 
 */
public class Contact extends ExtensibleModel {

	public static enum GENDER {
		MALE, FEMALE
	}

	public static enum MARITAL_STATUS {
		SINGLE, MARRIED, DIVORCED, OTHER
	}

	public static enum EMAIL_FORMAT_PREFERENCE {
		HTML, PLAIN_TEXT
	}

	public static enum HIGHEST_LEVEL_OF_EDUCATION {
		GRAMMAR_MIDDLE_SCHOOL, HIGH_SCHOOL, SOME_COLLEGE, BACHELORS_DEGREE, MASTERS_DEGREE, DOCTORATE_DEGREE
	}

	public static enum SALUTATION {
		MR, MS, DR, MRS
	}
	
	private Organization organization;

	private String firstName;
	private String lastName;
	
	private ArrayList<EmailAddress> emailAddresses = new ArrayList<EmailAddress>();
	private ArrayList<Company> companies = new ArrayList<Company>();
	private ArrayList<TelephoneNumber> telephoneNumbers = new ArrayList<TelephoneNumber>();
	private ArrayList<Address> adresses = new ArrayList<Address>();
	
	private SALUTATION salutation;
	private GENDER gender;
	private HIGHEST_LEVEL_OF_EDUCATION highestLevelOfEducation;
	private MARITAL_STATUS maritalStatus;
	private EMAIL_FORMAT_PREFERENCE emailFormatPreference;
	
	private Calendar birthdate;
	private ArrayList<SocialHandle> socialHandles;
	private ArrayList<CookiesSet> cookiesSets;
	private ArrayList<Subscription> subscriptions;

	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((adresses == null) ? 0 : adresses.hashCode());
		result = prime * result
				+ ((birthdate == null) ? 0 : birthdate.hashCode());
		result = prime * result
				+ ((companies == null) ? 0 : companies.hashCode());
		result = prime * result
				+ ((cookiesSets == null) ? 0 : cookiesSets.hashCode());
		result = prime * result
				+ ((emailAddresses == null) ? 0 : emailAddresses.hashCode());
		result = prime
				* result
				+ ((emailFormatPreference == null) ? 0 : emailFormatPreference
						.hashCode());
		result = prime * result
				+ ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((gender == null) ? 0 : gender.hashCode());
		result = prime
				* result
				+ ((highestLevelOfEducation == null) ? 0
						: highestLevelOfEducation.hashCode());
		result = prime * result
				+ ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result
				+ ((maritalStatus == null) ? 0 : maritalStatus.hashCode());
		result = prime * result
				+ ((organization == null) ? 0 : organization.hashCode());
		result = prime * result
				+ ((salutation == null) ? 0 : salutation.hashCode());
		result = prime * result
				+ ((socialHandles == null) ? 0 : socialHandles.hashCode());
		result = prime * result
				+ ((subscriptions == null) ? 0 : subscriptions.hashCode());
		result = prime
				* result
				+ ((telephoneNumbers == null) ? 0 : telephoneNumbers.hashCode());
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
		Contact other = (Contact) obj;
		if (adresses == null) {
			if (other.adresses != null)
				return false;
		} else if (!adresses.equals(other.adresses))
			return false;
		if (birthdate == null) {
			if (other.birthdate != null)
				return false;
		} else if (!birthdate.equals(other.birthdate))
			return false;
		if (companies == null) {
			if (other.companies != null)
				return false;
		} else if (!companies.equals(other.companies))
			return false;
		if (cookiesSets == null) {
			if (other.cookiesSets != null)
				return false;
		} else if (!cookiesSets.equals(other.cookiesSets))
			return false;
		if (emailAddresses == null) {
			if (other.emailAddresses != null)
				return false;
		} else if (!emailAddresses.equals(other.emailAddresses))
			return false;
		if (emailFormatPreference != other.emailFormatPreference)
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (gender != other.gender)
			return false;
		if (highestLevelOfEducation != other.highestLevelOfEducation)
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (maritalStatus != other.maritalStatus)
			return false;
		if (organization == null) {
			if (other.organization != null)
				return false;
		} else if (!organization.equals(other.organization))
			return false;
		if (salutation != other.salutation)
			return false;
		if (socialHandles == null) {
			if (other.socialHandles != null)
				return false;
		} else if (!socialHandles.equals(other.socialHandles))
			return false;
		if (subscriptions == null) {
			if (other.subscriptions != null)
				return false;
		} else if (!subscriptions.equals(other.subscriptions))
			return false;
		if (telephoneNumbers == null) {
			if (other.telephoneNumbers != null)
				return false;
		} else if (!telephoneNumbers.equals(other.telephoneNumbers))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Contact [salutation=" + salutation + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", emailAddresses="
				+ emailAddresses + ", companies=" + companies
				+ ", telephoneNumbers=" + telephoneNumbers + ", adresses="
				+ adresses + ", gender=" + gender
				+ ", highestLevelOfEducation=" + highestLevelOfEducation
				+ ", maritalStatus=" + maritalStatus
				+ ", emailFormatPreference=" + emailFormatPreference
				+ ", birthdate=" + birthdate + ", organization=" + organization
				+ ", socialHandles=" + socialHandles + ", cookiesSets="
				+ cookiesSets + ", subscriptions=" + subscriptions + "]";
	}

	public GENDER getGender() {
		return gender;
	}

	public void setGender(GENDER gender) {
		this.gender = gender;
	}

	public ArrayList<Company> getCompanies() {
		return companies;
	}

	public void setCompanies(ArrayList<Company> companies) {
		this.companies = companies;
	}

	public ArrayList<TelephoneNumber> getTelephoneNumbers() {
		return telephoneNumbers;
	}

	public void setTelephoneNumbers(ArrayList<TelephoneNumber> telephoneNumbers) {
		this.telephoneNumbers = telephoneNumbers;
	}

	public SALUTATION getSalutation() {
		return salutation;
	}

	public void setSalutation(SALUTATION salutation) {
		this.salutation = salutation;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public ArrayList<Address> getAdresses() {
		return adresses;
	}

	public void setAdresses(ArrayList<Address> adresses) {
		this.adresses = adresses;
	}

	public HIGHEST_LEVEL_OF_EDUCATION getHighestLevelOfEducation() {
		return highestLevelOfEducation;
	}

	public void setHighestLevelOfEducation(
			HIGHEST_LEVEL_OF_EDUCATION highestLevelOfEducation) {
		this.highestLevelOfEducation = highestLevelOfEducation;
	}

	public MARITAL_STATUS getMaritalStatus() {
		return maritalStatus;
	}

	public void setMaritalStatus(MARITAL_STATUS maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	public ArrayList<EmailAddress> getEmailAddresses() {
		return emailAddresses;
	}

	public void setEmailAddresses(ArrayList<EmailAddress> emailAddresses) {
		this.emailAddresses = emailAddresses;
	}

	public Organization getOrganization() {
		return organization;
	}

	public void setOrganization(Organization organization) {
		this.organization = organization;
	}

	public Calendar getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Calendar birthdate) {
		this.birthdate = birthdate;
	}

	public EMAIL_FORMAT_PREFERENCE getEmailFormatPreference() {
		return emailFormatPreference;
	}

	public void setEmailFormatPreference(
			EMAIL_FORMAT_PREFERENCE emailFormatPreference) {
		this.emailFormatPreference = emailFormatPreference;
	}

	public ArrayList<SocialHandle> getSocialHandles() {
		return socialHandles;
	}

	public void setSocialHandles(ArrayList<SocialHandle> socialHandles) {
		this.socialHandles = socialHandles;
	}

	public ArrayList<CookiesSet> getCookiesSets() {
		return cookiesSets;
	}

	public void setCookiesSets(ArrayList<CookiesSet> cookiesSets) {
		this.cookiesSets = cookiesSets;
	}

	public ArrayList<Subscription> getSubscriptions() {
		return subscriptions;
	}

	public void setSubscriptions(ArrayList<Subscription> subscriptions) {
		this.subscriptions = subscriptions;
	}
	
	

}
