/**
 * Copyright (c) 2014 Innominds. All Rights Reserved.
 */
package com.innominds.spring.service;

import java.util.List;

import com.innominds.spring.beans.Organization;

/**
 * OrganizationService.java
 *
 * @author ThirupathiReddy V
 *
 */
public interface OrganizationService {

    //

    /**
     * @return organization creates and returns organization object
     */
    public List<Organization> getAllOrganizations();

    /**
     * @param organization
     */
    public void saveOrganization(Organization organization);

}
