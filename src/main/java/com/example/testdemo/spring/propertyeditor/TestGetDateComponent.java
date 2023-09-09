package com.example.testdemo.spring.propertyeditor;

import jakarta.annotation.Resource;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Component
public class TestGetDateComponent implements InitializingBean {
    @Resource TestDateComponent testDateComponent;

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("将配置文件中的字符串通过自定义属性编辑器转换成了当前时间:"+testDateComponent.getDate().getYear());
    }
}
