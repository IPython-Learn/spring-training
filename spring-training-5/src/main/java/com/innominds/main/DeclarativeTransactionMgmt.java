/**
 * Copyright (c) 2014 Innominds. All Rights Reserved.
 */
package com.innominds.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.innominds.spring.beans.Organization;
import com.innominds.spring.service.OrganizationService;

/**
 *
 * DeclarativeTransactionMgmt.java
 *
 * @author ThirupathiReddy V
 *
 */
public class DeclarativeTransactionMgmt {

    /**
     * @param args
     */
    public static void main(String[] args) {

        try (ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring-tx-declarative.xml")) {

            final OrganizationService organizationService = ctx.getBean(OrganizationService.class);

            organizationService.getAllOrganizations();

            organizationService.saveOrganization(new Organization());
        }

    }
}
