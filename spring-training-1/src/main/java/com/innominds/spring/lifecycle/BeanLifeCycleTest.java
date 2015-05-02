/**
 * Copyright (c) 2014 Innominds. All Rights Reserved.
 */
package com.innominds.spring.lifecycle;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.innominds.spring.beans.Employee;
import com.innominds.spring.beans.LifecycleBean;

/**
 * BeanLifeCycleTest.java
 *
 * @author ThirupathiReddy V
 *
 */
public class BeanLifeCycleTest {

    /**
     * @param args
     */
    public static void main(String[] args) {
        //
        final ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("bean-lifecycle.xml");

        System.err.println(ctx.getBean(Employee.class));

        System.err.println(ctx.getBean(Employee.class));

        System.err.println(ctx.getBean(LifecycleBean.class));

        System.err.println(ctx.getBean(LifecycleBean.class));

        ctx.close();
    }

}
