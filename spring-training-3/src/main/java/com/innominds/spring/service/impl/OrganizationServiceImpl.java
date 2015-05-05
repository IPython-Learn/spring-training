/**
 * Copyright (c) 2014 Innominds. All Rights Reserved.
 */
package com.innominds.spring.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.innominds.spring.beans.Organization;
import com.innominds.spring.dao.OrganizationDao;
import com.innominds.spring.service.OrganizationService;

/**
 * OrganizationService.java
 *
 * @author ThirupathiReddy V
 *
 */
@Service("organizationService")
public class OrganizationServiceImpl implements OrganizationService {

    @Autowired
    OrganizationDao organizationDao;

    @Override
    public List<Organization> getAllOrganizations() {

        return organizationDao.findAll();
    }

    @Override
    public void saveOrganization(Organization organization) {
        organizationDao.save(organization);

    }

}
