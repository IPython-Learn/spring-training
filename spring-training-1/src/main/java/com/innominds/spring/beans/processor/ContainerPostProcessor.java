/**
 * Copyright (c) 2014 Innominds. All Rights Reserved.
 */
package com.innominds.spring.beans.processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * ContainerPostProcessor.java
 *
 * @author ThirupathiReddy V
 *
 */
public class ContainerPostProcessor implements BeanFactoryPostProcessor {

    /**
     * @param args
     */
    public static void main(String[] args) {
        try (ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("bean-processor.xml")) {
            // TODO: Invoke spring beans here
        }

    }

    /**
     * Constructor
     *
     */
    public ContainerPostProcessor() {
        System.err.println(" ContainerPostProcessor ");
    }

    /**
     * This method is called once the container created and before beans objects created in the case of applicationContext container. but still you can call
     * specific bean and perform some operations.
     */
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {

        // System.out.println(beanFactory.getBean(Employee.class).getName());
        System.err.println("#################################################");
        System.err.println("######### WELCOME TO SPRING TRAINING  ############");
        System.err.println("#################################################");
    }

}
