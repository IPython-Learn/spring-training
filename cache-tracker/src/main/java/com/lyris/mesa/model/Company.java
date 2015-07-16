package com.lyris.mesa.model;

/**
 * This class defines the company attribute of the contact.
 * 
 * @author dnabi
 * @version 1.0, August 2013
 */
public class Company {

	private String name;
	private String industry;
	private int numberOfEmployees;
	private Double annualRevenue;
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((annualRevenue == null) ? 0 : annualRevenue.hashCode());
		result = prime * result
				+ ((industry == null) ? 0 : industry.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + numberOfEmployees;
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
		Company other = (Company) obj;
		if (annualRevenue == null) {
			if (other.annualRevenue != null)
				return false;
		} else if (!annualRevenue.equals(other.annualRevenue))
			return false;
		if (industry == null) {
			if (other.industry != null)
				return false;
		} else if (!industry.equals(other.industry))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (numberOfEmployees != other.numberOfEmployees)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Company [name=" + name + ", industry=" + industry
				+ ", numberOfEmployees=" + numberOfEmployees
				+ ", annualRevenue=" + annualRevenue + "]";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIndustry() {
		return industry;
	}
	public void setIndustry(String industry) {
		this.industry = industry;
	}
	public int getNumberOfEmployees() {
		return numberOfEmployees;
	}
	public void setNumberOfEmployees(int numberOfEmployees) {
		this.numberOfEmployees = numberOfEmployees;
	}
	public Double getAnnualRevenue() {
		return annualRevenue;
	}
	public void setAnnualRevenue(Double annualRevenue) {
		this.annualRevenue = annualRevenue;
	}
	

	
}
