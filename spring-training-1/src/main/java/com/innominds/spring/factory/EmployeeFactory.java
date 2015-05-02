/**
 * Copyright (c) 2014 Innominds. All Rights Reserved.
 */
package com.innominds.spring.factory;

import java.util.logging.Logger;

import com.innominds.spring.beans.Employee;

/**
 * EmployeeFactory.java
 *
 * @author ThirupathiReddy V
 *
 */
public class EmployeeFactory {

    static Logger LOGGER = Logger.getLogger(EmployeeFactory.class.getSimpleName());

    private EmployeeFactory() {
        EmployeeFactory.LOGGER.info("EmployeeFactory  " + this);
    }

    /**
     * @return {@link Employee}
     */
    public static Employee getEmployee() {

        EmployeeFactory.LOGGER.info("getEmployee  ");
        return new Employee();
    }

}
