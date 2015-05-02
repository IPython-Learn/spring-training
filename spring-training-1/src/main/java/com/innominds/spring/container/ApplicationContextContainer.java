package com.innominds.spring.container;

import java.util.logging.Logger;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.innominds.spring.beans.Employee;

/**
 * <p>
 * singleton beans are created at the time of loading bean definitions.<br>
 * prototype beans are created on demand.
 * </p>
 *
 * ApplicationContextContainer.java
 *
 * @author ThirupathiReddy V
 *
 */
public class ApplicationContextContainer {

    static Logger LOGGER = Logger.getLogger(ApplicationContextContainer.class.getSimpleName());

    /**
     * @param args
     */
    public static void main(String[] args) {
        //
        final ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring-container.xml");

        ApplicationContextContainer.LOGGER.info("Bean Definitions loaded ");

        Employee employee = ctx.getBean(Employee.class);

        System.err.println(" Employee " + employee);

        employee = ctx.getBean(Employee.class);

        System.err.println(" Employee " + employee);

        employee = ctx.getBean(Employee.class);

        System.err.println(" Employee " + employee);

        ctx.close();
    }
}
