/**
 * Copyright (c) 2014 Innominds. All Rights Reserved.
 */
package com.innominds.spring.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.innominds.spring.service.EmployeeService;

/**
 * ContextModuleTest.java
 *
 * @author ThirupathiReddy V
 *
 */
public class ContextModuleTest {

    /**
     * @param args
     */
    public static void main(String[] args) {

        //

        final ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring-context.xml");

        final EmployeeService employeeService = (EmployeeService) ctx.getBean("employeeService");

        System.err.println(employeeService.getEmployee("DEVID"));

        System.err.println(employeeService.getEmployee("JOHN"));

        ctx.close();
    }

}
