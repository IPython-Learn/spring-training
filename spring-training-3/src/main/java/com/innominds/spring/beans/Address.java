/**
 * Copyright (c) 2014 Innominds. All Rights Reserved.
 */
package com.innominds.spring.beans;

import java.io.Serializable;

/**
 * Address.java
 *
 * @author ThirupathiReddy V
 *
 */
public class Address implements Serializable {

    /**
     * Reference to serialVersionUID
     */
    private static final long serialVersionUID = 1L;

    private String address;

    private String zip;

    private String phone;

    private String city;

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
     * This method returns the value held within the field zip.
     *
     * @return the zip
     */
    public String getZip() {
        return zip;
    }

    /**
     * This method sets the specified value (zip) to the field (zip).
     *
     * @param zip
     *            the zip to set
     */
    public void setZip(String zip) {
        this.zip = zip;
    }

    /**
     * This method returns the value held within the field phone.
     *
     * @return the phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * This method sets the specified value (phone) to the field (phone).
     *
     * @param phone
     *            the phone to set
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * This method returns the value held within the field city.
     *
     * @return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * This method sets the specified value (city) to the field (city).
     *
     * @param city
     *            the city to set
     */
    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Address [address=" + address + ", zip=" + zip + ", phone=" + phone + ", city=" + city + "]";
    }

}
