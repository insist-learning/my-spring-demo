package com.example.testdemo.spring.propertyeditor;

import com.example.testdemo.TestdemoApplication;
import com.example.testdemo.springboot.TestApplicationHook;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringApplicationHook;
import org.springframework.stereotype.Component;

@Component
public class TestGetDateComponent implements InitializingBean {
    @Resource(name = "testDateComponent") // (name = "testDateComponent") (type = TestDateComponent.class
    private TestDateComponent testDateComponent;

    @Resource(name = "testDateComponent2")
    private TestDateComponent testDateComponent2;



    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("将配置文件中的字符串通过自定义属性编辑器转换成了当前时间:"+testDateComponent.getDate().getYear());
        System.out.println("将配置文件中的字符串通过自定义属性编辑器转换成了当前时间:"+testDateComponent2.getDate().getYear());
    }

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(TestdemoApplication.class);
        springApplication.run(args);
    }

}
