/**
 * Copyright (c) 2014 Innominds. All Rights Reserved.
 */
package com.innominds.spring.factory;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.innominds.spring.beans.Employee;

/**
 * FactoryMethodInvocation.java
 *
 * @author ThirupathiReddy V
 *
 */
public class FactoryMethodInvocation {

    /**
     * @param args
     */
    public static void main(String[] args) {
        //

        final Employee emp = EmployeeFactory.getEmployee();
        System.out.println(emp);

        final ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("factory-method.xml");

        final Employee employee = (Employee) ctx.getBean("employee");

        System.err.println(employee);

        ctx.close();

    }

}
