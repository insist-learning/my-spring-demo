package com.example.testdemo.springboot;

import com.example.testdemo.TestdemoApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;

public class TestApplicationContextIntializers implements ApplicationContextInitializer {
    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        System.out.println("容器初始化完成");
    }

    // 添加容器的初始化监听器
    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(TestdemoApplication.class);
        springApplication.addInitializers(new TestApplicationContextIntializers());
        springApplication.run(args);
    }
}
