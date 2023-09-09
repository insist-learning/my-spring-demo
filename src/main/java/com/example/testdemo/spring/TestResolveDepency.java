package com.example.testdemo.spring;

import jakarta.annotation.Resource;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.boot.web.servlet.context.AnnotationConfigServletWebApplicationContext;
import org.springframework.boot.web.servlet.context.AnnotationConfigServletWebServerApplicationContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class TestResolveDepency implements InitializingBean, ApplicationContextAware {
    @Resource
    private ApplicationEventPublisher applicationEventPublisher;


    @Override
    public void afterPropertiesSet() throws Exception {
        if (applicationEventPublisher instanceof AnnotationConfigServletWebServerApplicationContext applicationContext) {
            System.out.println("is applicationContext");
        }
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {

    }


}
