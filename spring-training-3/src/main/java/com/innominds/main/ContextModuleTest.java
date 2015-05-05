/**
 * Copyright (c) 2015 Innominds. All Rights Reserved.
 */
package com.innominds.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.innominds.spring.beans.Organization;
import com.innominds.spring.service.OrganizationService;

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

        try (ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring-jdbc.xml")) {

            /*
             * final EmployeeService employeeService = (EmployeeService) ctx.getBean("employeeService");
             * 
             * employeeService.saveEmployee(new Employee("John", "Developer"));
             * 
             * System.out.println(employeeService.getAllEmployees());
             */
            final OrganizationService organizationService = (OrganizationService) ctx.getBean("organizationService");
            organizationService.saveOrganization(new Organization("Innominds", "QCity"));

            System.out.println(organizationService.getAllOrganizations());

        }

    }
}
