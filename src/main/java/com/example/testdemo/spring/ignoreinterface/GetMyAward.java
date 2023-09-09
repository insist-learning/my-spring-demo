package com.example.testdemo.spring.ignoreinterface;

import jakarta.annotation.Resource;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Component
public class GetMyAward implements InitializingBean {

    @Resource
    private MyAward myAward;


    @Override
    public void afterPropertiesSet() throws Exception {
        myAward.test();
    }
}
