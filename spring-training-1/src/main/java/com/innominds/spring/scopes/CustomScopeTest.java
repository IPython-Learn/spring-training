package com.innominds.spring.scopes;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * CustomScopeTest.java
 *
 * @author ThirupathiReddy V
 *
 */
public class CustomScopeTest {

    /**
     * @param args
     */
    public static void main(String[] args) {

        final ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("custom-scopes.xml");

        System.out.println(ctx.getBean("employee"));
        System.out.println(ctx.getBean("employee"));

        final Runnable runnable = new Runnable() {

            @Override
            public void run() {

                System.out.println(ctx.getBean("employee"));

            }
        };

        for (int i = 0; i < 5; i++) {
            new Thread(runnable).start();
        }

        ctx.close();

    }
}
