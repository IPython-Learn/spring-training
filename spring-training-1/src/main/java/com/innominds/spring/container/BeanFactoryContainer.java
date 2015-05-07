package com.innominds.spring.container;

import java.util.logging.Logger;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;

import com.innominds.spring.beans.Employee;

/**
 * <p>
 * Beans are created on demand.
 * </p>
 * BeanFactoryContainer.java
 *
 * @author ThirupathiReddy V
 *
 */
public class BeanFactoryContainer {

    static Logger LOGGER = Logger.getLogger(BeanFactoryContainer.class.getSimpleName());

    /**
     * @param args
     */
    public static void main(String[] args) {

        final DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        final XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        // reader.setValidating(false);

        reader.loadBeanDefinitions(new ClassPathResource("spring-container.xml"));

        BeanFactoryContainer.LOGGER.info("   Bean definitions loaded ");

        final Employee employee = (Employee) beanFactory.getBean("employee");

        BeanFactoryContainer.LOGGER.info("Employee  :  " + employee);

    }
}
