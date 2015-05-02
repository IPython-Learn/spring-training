/**
 * Copyright (c) 2014 Innominds. All Rights Reserved.
 */
package com.innominds.application.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.innominds.spring.beans.Employee;

/**
 * <p>
 * NOTE: method name acts as bean in while accessing the bean.<br>
 * hence don't following java bean naming standards here.
 * </p>
 *
 * ParentAppConfig.java
 *
 * @author ThirupathiReddy V
 *
 */
@SuppressWarnings("static-method")
@Configuration
public class ParentAppConfig {

    /**
     * @return employee
     */
    @Bean(initMethod = "init", destroyMethod = "destroy")
    public Employee employee() {

        return new Employee();
    }
}
