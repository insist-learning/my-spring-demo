package com.example.testdemo.springboot;

import com.example.testdemo.TestdemoApplication;
import org.springframework.boot.SpringApplication;

public class TestAddictionalProfiles
{
    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(TestdemoApplication.class);
        springApplication.setAdditionalProfiles("p1");
        springApplication.run(args);
    }



}
