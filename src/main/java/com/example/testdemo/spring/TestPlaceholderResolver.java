package com.example.testdemo.spring;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class TestPlaceholderResolver implements InitializingBean {
    @Value("jlkajdkljalk---${server.port:}---${server.port:}---${spring.datasource.url:}")
    private  String port;


    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("this port is "+port);
    }
}
