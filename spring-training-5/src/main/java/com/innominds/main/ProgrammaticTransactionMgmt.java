/**
 * Copyright (c) 2014 Innominds. All Rights Reserved.
 */
package com.innominds.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.innominds.spring.beans.Employee;
import com.innominds.spring.service.EmployeeService;

/**
 * <p>
 * The Spring Framework provides two means of programmatic transaction management:
 * <ul>
 * <li>Using the TransactionTemplate.</li>
 * <li>Using a PlatformTransactionManager implementation directly.</li>
 * </ul>
 *
 * <b>PlatformTransactionManager</b> has two default implementations.
 * <ol>
 * <li>org.springframework.transaction.jta.JtaTransactionManager</li>
 * <li>org.springframework.jdbc.datasource.DataSourceTransactionManager</li>
 * </ol>
 *
 * </p>
 * ProgrammaticTransactionMgmt.java
 *
 * @author ThirupathiReddy V
 *
 */
public class ProgrammaticTransactionMgmt {

    /**
     * @param args
     */
    public static void main(String[] args) {

        try (ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring-tx-programmatic.xml")) {

            final EmployeeService employeeService = ctx.getBean(EmployeeService.class);

            System.out.println(employeeService.saveEmployee(new Employee()));
        }

    }
}
