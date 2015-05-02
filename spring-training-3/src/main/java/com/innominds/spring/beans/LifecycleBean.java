/**
 * Copyright (c) 2014 Innominds. All Rights Reserved.
 */
package com.innominds.spring.beans;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

/**
 * LifecycleBean.java
 *
 * @author ThirupathiReddy V
 *
 */
public class LifecycleBean implements InitializingBean, DisposableBean {

    @Override
    public void destroy() throws Exception {
        System.err.println("LifecycleBean :  destroying  bean");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.err.println(" LifecycleBean:    afterPropertieSet invoked  ");
    }

}
