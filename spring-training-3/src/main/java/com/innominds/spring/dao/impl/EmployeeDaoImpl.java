/**
 * Copyright (c) 2015 Innominds. All Rights Reserved.
 */
package com.innominds.spring.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.innominds.spring.beans.Employee;
import com.innominds.spring.dao.EmployeeDao;

/**
 * EmployeeDaoImpl.java
 *
 * @author ThirupathiReddy V
 *
 */
@Repository("employeeDao")
public class EmployeeDaoImpl implements EmployeeDao {
    //

    /**
     * gives an idea how to autoWiring beans with annotations.
     */
    @Autowired
    JdbcTemplate jdbcTemplate;

    /**
     * creates database table if it not exists. this one life cycle method declaration using java annotation.
     */
    @PostConstruct
    public void initializeDB() {

        jdbcTemplate.execute("CREATE TABLE IF NOT EXISTS `employee` (" + "`id` int(11) NOT NULL AUTO_INCREMENT," + "`name` varchar(45) DEFAULT NULL,"
                + "`designation` varchar(45) DEFAULT NULL," + "PRIMARY KEY (`id`)" + ")");
    }

    @Override
    public List<Employee> findAll() {

        final List<Employee> employees = jdbcTemplate.query("SELECT * FROM EMPLOYEE", new EmployeeRowMapper());

        return employees;
    }

    @Override
    public void save(Employee employee) {

        final String SQL = "INSERT INTO EMPLOYEE(name,designation)  VALUES(?,?)";

        jdbcTemplate.update(SQL, new Object[] { employee.getName(), employee.getDesignation() });
    }

}

/**
 * <p>
 * This inner class lets allows us to map DB table columns with Java Object properties.
 * </p>
 *
 * EmployeeDaoImpl.java
 *
 * @author ThirupathiReddy V
 *
 */
class EmployeeRowMapper implements RowMapper<Employee> {

    @Override
    public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
        final Employee employee = new Employee();
        employee.setDesignation(rs.getString("designation"));
        employee.setName(rs.getString("name"));
        return employee;
    }
    //
}
