/**
 * Copyright (c) 2014 Innominds. All Rights Reserved.
 */
package com.innominds.spring.inheritance;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * SpringInheritanceTest.java
 *
 * @author ThirupathiReddy V
 *
 */
public class SpringInheritanceTest {

    /**
     * @param args
     */
    public static void main(String[] args) {

        final ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring-inheritance.xml");

        System.err.println(ctx.getBean("address"));

        ctx.close();
    }
}
