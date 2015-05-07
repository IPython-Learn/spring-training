/**
 * Copyright (c) 2014 Innominds. All Rights Reserved.
 */
package com.innominds.application.config;

import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.innominds.spring.beans.Address;

/**
 * <p>
 * This replacement for spring XML configuration, to configure spring beans.<br>
 *
 * </p>
 * InnomindsAppConfig.java
 *
 * @author ThirupathiReddy V
 *
 */
@SuppressWarnings("static-method")
@Configuration
public class InnomindsAppConfig {

    /**
     * @return address
     */

    @Bean(autowire = Autowire.BY_NAME)
    @Scope(value = "prototype")
    public Address address() {
        return new Address();
    }

}
