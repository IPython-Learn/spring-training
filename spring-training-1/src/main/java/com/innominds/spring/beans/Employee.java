package com.innominds.spring.beans;

/**
 * Employee.java
 *
 * @author ThirupathiReddy V
 *
 */
@SuppressWarnings("static-method")
public class Employee {

    /**
     * Constructor
     *
     */
    public Employee() {

        System.err.println(" Employee Bean Constructor  :  = " + this);
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

    /*
     * @Override public String toString() {
     * 
     * return "Employee [name=" + name + ", organization=" + organization + "]"; }
     */

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
