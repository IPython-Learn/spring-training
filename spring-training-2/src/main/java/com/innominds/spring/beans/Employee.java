package com.innominds.spring.beans;

import java.util.logging.Logger;

/**
 * Employee.java
 *
 * @author ThirupathiReddy V
 *
 */
@SuppressWarnings("static-method")
public class Employee {
    static Logger LOGGER = Logger.getLogger(Employee.class.getSimpleName());

    /**
     * Constructor
     *
     */
    public Employee() {

        Employee.LOGGER.info(" Employee Bean Created :  = " + this);
    }

    /**
     *
     */
    public void destroy() {
        Employee.LOGGER.info(" Employee bean destroying...");
    }

    /**
     *
     */
    public void init() {
        Employee.LOGGER.info(" Employee bean created. ");
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

    @Override
    public String toString() {
        return "Employee [name=" + name + "]";
    }

    private Organization organization;

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
