package com.lyris.mesa.model;

import java.util.List;

import com.lyris.mesa.model.support.ExtensibleModel;

/**
 * This class defines a canonical model of organization object
 * 
 * @author dnabi
 * @version 1.0, August 2013
 */
public class Organization extends ExtensibleModel {

	private String id;
	private String name;
	private List<Organization> children;
	private List<Contact> contacts;
	private boolean allowedToAccessParentContacts = true;
	private boolean allowedToHaveContacts = true;
	private List<SubscriptionOffering> subscriptionOfferings;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + (allowedToAccessParentContacts ? 1231 : 1237);
		result = prime * result + (allowedToHaveContacts ? 1231 : 1237);
		result = prime * result
				+ ((children == null) ? 0 : children.hashCode());
		result = prime * result
				+ ((contacts == null) ? 0 : contacts.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime
				* result
				+ ((subscriptionOfferings == null) ? 0 : subscriptionOfferings
						.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Organization other = (Organization) obj;
		if (allowedToAccessParentContacts != other.allowedToAccessParentContacts)
			return false;
		if (allowedToHaveContacts != other.allowedToHaveContacts)
			return false;
		if (children == null) {
			if (other.children != null)
				return false;
		} else if (!children.equals(other.children))
			return false;
		if (contacts == null) {
			if (other.contacts != null)
				return false;
		} else if (!contacts.equals(other.contacts))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (subscriptionOfferings == null) {
			if (other.subscriptionOfferings != null)
				return false;
		} else if (!subscriptionOfferings.equals(other.subscriptionOfferings))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Organization [id=" + id + ", name=" + name + ", children="
				+ children + ", contacts=" + contacts
				+ ", allowedToAccessParentContacts="
				+ allowedToAccessParentContacts + ", allowedToHaveContacts="
				+ allowedToHaveContacts + ", subscriptionOfferings="
				+ subscriptionOfferings + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<Organization> getChildren() {
		return children;
	}

	public void setChildren(List<Organization> children) {
		this.children = children;
	}

	public List<Contact> getContacts() {
		return contacts;
	}

	public void setContacts(List<Contact> contacts) {
		this.contacts = contacts;
	}

	public boolean isAllowedToAccessParentContacts() {
		return allowedToAccessParentContacts;
	}

	public void setAllowedToAccessParentContacts(
			boolean allowedToAccessParentContacts) {
		this.allowedToAccessParentContacts = allowedToAccessParentContacts;
	}

	public boolean isAllowedToHaveContacts() {
		return allowedToHaveContacts;
	}

	public void setAllowedToHaveContacts(boolean allowedToHaveContacts) {
		this.allowedToHaveContacts = allowedToHaveContacts;
	}

	public List<SubscriptionOffering> getSubscriptionOfferings() {
		return subscriptionOfferings;
	}

	public void setSubscriptionOfferings(
			List<SubscriptionOffering> subscriptionOfferings) {
		this.subscriptionOfferings = subscriptionOfferings;
	}

}
