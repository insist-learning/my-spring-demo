package com.example.testdemo.spring.resolveDependency;

import jakarta.annotation.Resource;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

@Component
public class TestGetResolve implements InitializingBean {

    @Resource
    private TestResolve testResolve;


    @Override
    public void afterPropertiesSet() throws Exception {
        if (null != testResolve) {
            testResolve.myResolve();
        }
    }
}
