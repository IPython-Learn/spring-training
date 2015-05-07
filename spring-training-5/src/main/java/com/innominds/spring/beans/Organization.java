package com.innominds.spring.beans;

import java.io.Serializable;

/**
 * Employee.java
 *
 * @author ThirupathiReddy V
 *
 */

public class Organization implements Serializable {

    /**
     * Reference to serialVersionUID
     */
    private static final long serialVersionUID = 1L;

    private String id;

    private String name;

    private String address;

    /**
     * Constructor
     *
     */
    public Organization() {
        // TODO Auto-generated constructor stub
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
     * This method returns the value held within the field address.
     *
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * This method sets the specified value (address) to the field (address).
     *
     * @param address
     *            the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Constructor
     *
     * @param id
     * @param name
     * @param address
     */
    public Organization(String id, String name, String address) {
        super();
        this.id = id;
        this.name = name;
        this.address = address;
    }

    /**
     * Constructor
     *
     * @param name
     * @param address
     */
    public Organization(String name, String address) {
        super();
        this.name = name;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Organization [id=" + id + ", name=" + name + ", address=" + address + "]";
    }

}
