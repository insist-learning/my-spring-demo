package com.example.testdemo.spring.require;

import com.example.testdemo.TestdemoApplication;
import com.example.testdemo.springboot.TestApplicationHook;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringApplicationHook;

import javax.swing.*;

public class TestRequired {
    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(TestdemoApplication.class){

        };
        springApplication.run(args);
    }
}
