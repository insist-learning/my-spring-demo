package com.example.testdemo.springboot;

import com.example.testdemo.TestdemoApplication;
import org.springframework.boot.SpringApplication;

public class TestEnvironmentPrefix {
    public static void main(String[] args) {
        // 通过环境变量配置的时候可以设定前缀
        SpringApplication springApplication = new SpringApplication(TestdemoApplication.class);
        springApplication.setAdditionalProfiles("p1");
        springApplication.setEnvironmentPrefix("my");
        springApplication.run(args);
    }
}
