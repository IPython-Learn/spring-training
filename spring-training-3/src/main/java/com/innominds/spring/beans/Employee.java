package com.innominds.spring.beans;

import org.springframework.stereotype.Component;

/**
 * Employee.java
 *
 * @author ThirupathiReddy V
 *
 */
@SuppressWarnings("static-method")
@Component
public class Employee {

    /**
     * Constructor
     *
     */
    public Employee() {

    }

    /**
     *
     */
    public void destroy() {
        System.err.println(" ############### Employee lifecycle method destroy  called ################## ");
    }

    /**
     *
     */
    public void init() {
        System.err.println(" ############### Employee lifecycle method init  called ################## ");
    }

    private String name = "anonymous";

    private String designation;

    /**
     * This method returns the value held within the field designation.
     *
     * @return the designation
     */
    public String getDesignation() {
        return designation;
    }

    /**
     * This method sets the specified value (designation) to the field (designation).
     *
     * @param designation
     *            the designation to set
     */
    public void setDesignation(String designation) {
        this.designation = designation;
    }

    /**
     * Constructor
     *
     * @param name
     */
    public Employee(final String name) {
        this.name = name;
    }

    /**
     * This method sets the specified value (name) to the field (name).
     *
     * @param name
     *            the name to set
     */
    public void setName(final String name) {
        this.name = name;
    }

    /**
     * This method returns the value held within the field name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Employee [name=" + name + ", designation=" + designation + "]";
    }

    private Organization organization;// new Organization();

    /**
     * This method sets the specified value (organization) to the field (organization).
     *
     * @param organization
     *            the organization to set
     */
    public void setOrganization(final Organization organization) {
        this.organization = organization;
    }

    /**
     * This method returns the value held within the field organization.
     *
     * @return the organization
     */
    public Organization getOrganization() {
        return organization;
    }

}
