/**
 * Copyright (c) 2014 Innominds. All Rights Reserved.
 */
package com.innominds.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.innominds.application.config.InnomindsAppConfig;

/**
 * Main.java
 *
 * @author ThirupathiReddy V
 *
 */
public class Main {

    /**
     * @param args
     */
    public static void main(String[] args) {
        //
        final AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(InnomindsAppConfig.class);

        System.out.println(ctx.getBean("address"));

        System.out.println(ctx.getBean("employee"));

        ctx.close();

    }
}
