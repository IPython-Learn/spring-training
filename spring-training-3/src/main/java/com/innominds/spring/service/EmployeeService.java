/**
 * Copyright (c) 2014 Innominds. All Rights Reserved.
 */
package com.innominds.spring.service;

import com.innominds.spring.beans.Employee;

/**
 * EmployeeService.java
 *
 * @author ThirupathiReddy V
 *
 */
public interface EmployeeService {

    /**
     * @param name
     *            input name of the employee
     * @return employee creates and returns employee object
     */
    Employee getEmployee(String name);
}
