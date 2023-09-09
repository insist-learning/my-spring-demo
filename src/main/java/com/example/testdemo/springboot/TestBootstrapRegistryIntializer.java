package com.example.testdemo.springboot;

import com.example.testdemo.TestdemoApplication;
import org.springframework.boot.BootstrapRegistry;
import org.springframework.boot.BootstrapRegistryInitializer;
import org.springframework.boot.SpringApplication;

public class TestBootstrapRegistryIntializer implements BootstrapRegistryInitializer {
    @Override
    public void initialize(BootstrapRegistry registry) {
        System.out.println("初始化");
    }
    // 添加容器的初始化监听器
    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(TestdemoApplication.class);
        springApplication.addBootstrapRegistryInitializer(new TestBootstrapRegistryIntializer());
        springApplication.run(args);
    }
}
