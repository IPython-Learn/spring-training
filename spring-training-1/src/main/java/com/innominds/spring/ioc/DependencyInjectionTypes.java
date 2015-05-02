/**
 * Copyright (c) 2014 Innominds. All Rights Reserved.
 */
package com.innominds.spring.ioc;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.innominds.spring.beans.Employee;

/**
 *
 * <p>
 * There are two types of Injection possible.
 * <ol>
 * <li>Constructor based injection</li>
 * <li>Setter based injection</li>
 * </ol>
 *
 * </p>
 * DependencyInjectionTypes.java
 *
 * @author ThirupathiReddy V
 *
 */
public class DependencyInjectionTypes {

    /**
     * @param args
     */
    public static void main(String[] args) {

        final ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("dependency-injection.xml");

        final Employee employee = (Employee) ctx.getBean("manager");

        System.err.println(" Employee  ::  " + employee);

        System.err.println("Organization :: " + employee.getOrganization());

        ctx.close();

    }

}
