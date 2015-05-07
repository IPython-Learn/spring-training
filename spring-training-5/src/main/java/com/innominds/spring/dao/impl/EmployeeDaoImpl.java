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
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

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

    @Autowired
    PlatformTransactionManager platformTransactionManager;

    @Autowired
    TransactionTemplate transactionTemplate;

    /**
     * creates database table if it not exists. this one life cycle method declaration using java annotation.
     */
    @PostConstruct
    public void initializeDB() {

        System.err.println("platformTransactionManager :: " + platformTransactionManager);

        jdbcTemplate.execute("CREATE TABLE IF NOT EXISTS `employee` (" + "`id` int(11) NOT NULL AUTO_INCREMENT," + "`name` varchar(45) NOT NULL,"
                + "`designation` varchar(45) DEFAULT NULL," + "PRIMARY KEY (`id`)" + ")");
    }

    @Override
    public List<Employee> findAll() {

        final List<Employee> employees = jdbcTemplate.query("SELECT * FROM EMPLOYEE", new EmployeeRowMapper());

        return employees;
    }

    @Override
    public int save(Employee employee) {

        final String SQL = "INSERT INTO EMPLOYEE(name,designation)  VALUES(?,?)";

        jdbcTemplate.update(SQL, new Object[] { "WITHOUT_TX", "DEVELOPER" });

        // use TransactionCallback handler if some result is returned
        return transactionTemplate.execute(new TransactionCallback<Integer>() {
            @Override
            public Integer doInTransaction(TransactionStatus paramTransactionStatus) {

                jdbcTemplate.update(SQL, new Object[] { "WITH_TX", "DEVELOPER" });

                return jdbcTemplate.update(SQL, new Object[] { employee.getName(), employee.getDesignation() });
            }
        });

    }

    @Override
    public void deleteEmployee(int id) {

        final DefaultTransactionDefinition paramTransactionDefinition = new DefaultTransactionDefinition();

        final TransactionStatus status = platformTransactionManager.getTransaction(paramTransactionDefinition);

        try {
            final String delQuery = " DELETE FROM EMPLOYEE WHERE ID = ?";
            jdbcTemplate.update(delQuery, new Object[] { id });
            platformTransactionManager.commit(status);
        } catch (final Exception e) {
            platformTransactionManager.rollback(status);
        }
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
