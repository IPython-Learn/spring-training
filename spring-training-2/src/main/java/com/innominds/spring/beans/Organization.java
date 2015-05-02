/**
 * Copyright (c) 2014 Innominds. All Rights Reserved.
 */
package com.innominds.spring.beans;

import java.util.List;

/**
 * Organization.java
 *
 * @author ThirupathiReddy V
 *
 */
public class Organization {

    private String name;

    private List<Employee> employees;

    /**
     * Constructor
     *
     */
    public Organization() {

    }

    /**
     * Constructor
     *
     * @param name
     */
    public Organization(String name) {
        this.name = name;
    }

    /**
     * Constructor
     *
     * @param name
     * @param employees
     */
    public Organization(String name, List<Employee> employees) {
        this.name = name;
        this.employees = employees;
    }

    /**
     * This method returns the value held within the field name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * This method sets the specified value (name) to the field (name).
     *
     * @param name
     *            the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * This method returns the value held within the field employees.
     *
     * @return the employees
     */
    public List<Employee> getEmployees() {
        return employees;
    }

    /**
     * This method sets the specified value (employees) to the field (employees).
     *
     * @param employees
     *            the employees to set
     */
    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

}
