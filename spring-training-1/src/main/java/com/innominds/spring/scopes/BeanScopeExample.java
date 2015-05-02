/**
 * Copyright (c) 2014 Innominds. All Rights Reserved.
 */
package com.innominds.spring.scopes;

import java.util.logging.Logger;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * <p>
 * 5 types of bean scopes supported :<br>
 *
 * <ul>
 * <li>singleton – Return a single bean instance per Spring IoC container.</li>
 * <li>prototype – Return a new bean instance each time when requested.</li>
 * <li>request – Return a single bean instance per HTTP request.</li>
 * <li>session – Return a single bean instance per HTTP session.</li>
 * <li>globalSession – Return a single bean instance per global HTTP session.</li>
 * </ul>
 *
 * <b>NOTE: request,session,globalSession scopes available in web application only</b>
 * </p>
 *
 *
 * BeanScopeExample.java
 *
 * @author ThirupathiReddy V
 *
 */
public class BeanScopeExample {

    static Logger LOGGER = Logger.getLogger(BeanScopeExample.class.getSimpleName());

    /**
     * @param args
     */
    public static void main(String[] args) {

        final ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("bean-scopes.xml");

        BeanScopeExample.LOGGER.info("Bean Definitions loaded ");

        BeanScopeExample.LOGGER.info("Employee 1 : " + ctx.getBean("employee"));

        BeanScopeExample.LOGGER.info("Employee 2 : " + ctx.getBean("employee"));

        ctx.close();
    }

}
