/**
 * Copyright (c) 2014 Innominds. All Rights Reserved.
 */
package com.innominds.spring.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.innominds.spring.beans.Employee;
import com.innominds.spring.dao.EmployeeDao;
import com.innominds.spring.service.EmployeeService;

/**
 * EmployeeServiceImpl.java
 *
 * @author ThirupathiReddy V
 *
 */
@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {

    private final Logger LOGGER = Logger.getLogger(EmployeeService.class);

    @Autowired
    EmployeeDao employeeDao;

    @Override
    public List<Employee> getAllEmployees() {
        LOGGER.info("Returning  all the employees ");
        return employeeDao.findAll();
    }

    @Override
    public void saveEmployee(Employee employee) {
        LOGGER.info("Save Employee ");
        employeeDao.save(employee);
    }

}
