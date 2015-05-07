/**
 * Copyright (c) 2014 Innominds. All Rights Reserved.
 */
package com.innominds.spring.dao;

import java.util.List;

import com.innominds.spring.beans.Employee;

/**
 * EmployeeDao.java
 *
 * @author ThirupathiReddy V
 *
 */
public interface EmployeeDao {
    //

    /**
     * @return employee list
     */
    public List<Employee> findAll();

    /**
     * @param employee
     * @return status
     */
    public int save(Employee employee);

    /**
     * @param id
     */
    public void deleteEmployee(int id);
}
