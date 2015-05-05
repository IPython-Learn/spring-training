/**
 * Copyright (c) 2015 Innominds. All Rights Reserved.
 */
package com.innominds.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.innominds.spring.beans.Employee;
import com.innominds.spring.service.EmployeeService;

/**
 * ContextModuleTest.java
 *
 * @author ThirupathiReddy V
 *
 */
public class AspectExample {

    /**
     * @param args
     */
    public static void main(String[] args) {

        //

        try (ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring-aop.xml")) {

            final EmployeeService employeeService = (EmployeeService) ctx.getBean("employeeService");

            employeeService.saveEmployee(new Employee("John", "Developer"));

            System.out.println(employeeService.getAllEmployees());
            // http://www.journaldev.com/2583/spring-aop-example-tutorial-aspect-advice-pointcut-joinpoint-annotations-xml-configuration
        }

    }

}
