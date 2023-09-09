package com.example.testdemo.spring.propertyeditor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class TestConfigFactory implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        if (beanFactory instanceof DefaultListableBeanFactory listableBeanFactory) {
            RootBeanDefinition rootBeanDefinition = new RootBeanDefinition(TestDateComponent.class);
            rootBeanDefinition.getPropertyValues().add("date", "testValue");
            listableBeanFactory.registerBeanDefinition("testDateComponent2", rootBeanDefinition);
        }
    }

}
