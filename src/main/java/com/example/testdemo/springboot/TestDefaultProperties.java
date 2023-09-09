package com.example.testdemo.springboot;


import com.example.testdemo.TestdemoApplication;
import org.springframework.boot.SpringApplication;

import java.util.HashMap;
import java.util.Map;

public class TestDefaultProperties {

    // spring 默认配置，优先级最低
    private static Map<String,Object> defaultMap = new HashMap<>(){
        {
            put("server.port", 9696);
        }
    };

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(TestdemoApplication.class);
        springApplication.setDefaultProperties(defaultMap);
        springApplication.run(args);
    }
}
