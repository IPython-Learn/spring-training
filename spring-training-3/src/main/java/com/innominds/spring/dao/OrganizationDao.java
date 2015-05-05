/**
 * Copyright (c) 2014 Innominds. All Rights Reserved.
 */
package com.innominds.spring.dao;

import java.util.List;

import com.innominds.spring.beans.Organization;

/**
 * OrganizationDao.java
 * 
 * @author ThirupathiReddy V
 *
 */
public interface OrganizationDao {

    /**
     * @param organization
     */
    public void save(Organization organization);

    /**
     * @return list
     */
    public List<Organization> findAll();
}
