/**
 * Copyright (c) 2014 Innominds. All Rights Reserved.
 */
package com.innominds.spring.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.innominds.spring.beans.Employee;
import com.innominds.spring.service.EmployeeService;
import com.jolbox.bonecp.BoneCPDataSource;

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
    BoneCPDataSource dataSource;

    private Connection connection;

    /**
     *
     */
    @PostConstruct
    public void init() {

        LOGGER.info("  INVOKING THE INIT METHOD   ");

        try {
            connection = dataSource.getConnection();
        } catch (final SQLException e) {
            LOGGER.error("error while establishing the connection with database ", e);
        }

    }

    @Override
    public Employee getEmployee(String name) {

        try {
            final PreparedStatement ps = connection.prepareStatement("SELECT * FROM  EMPLOYEE e WHERE e.name=? ");

            ps.setString(1, name);

            final ResultSet rs = ps.executeQuery();

            final Employee employee = new Employee();

            if (rs.next()) {
                employee.setName(rs.getString("name"));
                employee.setDesignation(rs.getString("designation"));
            }

            rs.close();
            ps.close();

            return employee;
        } catch (final SQLException e) {
            LOGGER.error("Error while  reading the data from the database ", e);
        }

        return null;
    }

    /**
     *
     */
    @PreDestroy
    public void destroy() {

        LOGGER.info("   INVOKING THE DESTROY METHOD   ");

        try {
            connection.close();
        } catch (final SQLException e) {
            LOGGER.error("error while closing the connection with database ", e);
        }

    }

}
