/**
 * Copyright (c) 2014 Innominds. All Rights Reserved.
 */
package com.innominds.spring.ioc;

import com.innominds.spring.beans.Employee;
import com.innominds.spring.beans.Organization;

/**
 * TraditionBeanInjection.java
 *
 * @author ThirupathiReddy V
 *
 */
public class TraditionBeanInjection {

    /**
     * @param args
     */
    public static void main(String[] args) {
        //

        final Employee employee = new Employee();
        employee.setName("Thiru");

        final Organization organization = new Organization();

        organization.setName("Innominds");

        // organization.setEmployees(Arrays.asList(employee));

        employee.setOrganization(organization);// injected Organization

        System.out.println(employee);
    }
}
