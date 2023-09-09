package com.example.testdemo.springboot;

import com.example.testdemo.TestdemoApplication;
import org.springframework.boot.SpringApplication;

public class TestConfigImport {
    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(TestdemoApplication.class);
        springApplication.run(args);
    }
}
