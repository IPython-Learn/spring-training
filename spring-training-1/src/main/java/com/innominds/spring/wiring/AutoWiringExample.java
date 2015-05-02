/**
 * Copyright (c) 2014 Innominds. All Rights Reserved.
 */
package com.innominds.spring.wiring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.innominds.spring.beans.Employee;

/**
 * AutoWiringExample.java
 *
 * @author ThirupathiReddy V
 *
 */
public class AutoWiringExample {

    /**
     * @param args
     */
    public static void main(String[] args) {

        final ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("bean-autowiring.xml");

        final Employee employee = (Employee) ctx.getBean("employee");

        System.out.println(employee.getOrganization());

        System.out.println(employee.getOrganization().getEmployees());

        ctx.close();

    }

}
