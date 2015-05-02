/**
 * Copyright (c) 2014 Innominds. All Rights Reserved.
 */
package com.innominds.spring.beans.processor;

import java.util.logging.Logger;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.innominds.spring.beans.Employee;

/**
 * EmployeeBeanProcessor.java
 *
 * @author ThirupathiReddy V
 *
 */
public class EmployeeBeanProcessor implements BeanPostProcessor {

    static Logger LOGGER = Logger.getLogger(EmployeeBeanProcessor.class.getSimpleName());

    /**
     * @param args
     */
    public static void main(String[] args) {

        final ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("bean-processor.xml");

        EmployeeBeanProcessor.LOGGER.info(" Beans loaded successfully ");

        System.err.println("   Employee Bean ::  " + ctx.getBean("employee"));

        final Employee employee = (Employee) ctx.getBean("employee");

        System.err.println(employee.getName());

        // closing the container
        ctx.close();

    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        EmployeeBeanProcessor.LOGGER.info("postProcessBeforeInitialization  : " + bean + "  with name : " + beanName);

        ((Employee) bean).setName("Name has Hijacked by Processor");

        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {

        EmployeeBeanProcessor.LOGGER.info("postProcessAfterInitialization  : " + bean + "  with name : " + beanName);

        return bean;
    }

}
