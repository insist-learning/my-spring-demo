package com.example.testdemo.springboot;

import com.example.testdemo.TestdemoApplication;
import org.springframework.boot.SpringApplication;

public class TestArgs {

    // 通过 args 向 spring 传参
    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(TestdemoApplication.class);
        springApplication.setLogStartupInfo(false);
        springApplication.run("--server.port=9898");
    }
}



