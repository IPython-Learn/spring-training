package com.innominds.spring.beans;

import java.io.Serializable;

/**
 * Employee.java
 *
 * @author ThirupathiReddy V
 *
 */

public class Employee implements Serializable {

    /**
     * Reference to serialVersionUID
     */
    private static final long serialVersionUID = 1L;

    private String id;

    private String name;

    private String designation;

    /**
     * Constructor
     *
     */
    public Employee() {

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
     * Constructor
     *
     * @param name
     * @param designation
     */
    public Employee(final String name, final String designation) {
        this.name = name;
        this.designation = designation;
    }

    /**
     * This method returns the value held within the field id.
     *
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * This method sets the specified value (id) to the field (id).
     *
     * @param id
     *            the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

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

}
