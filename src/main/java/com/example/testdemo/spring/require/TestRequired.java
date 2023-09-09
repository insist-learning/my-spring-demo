package com.example.testdemo.spring.require;

import com.example.testdemo.TestdemoApplication;
import com.example.testdemo.springboot.TestApplicationHook;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringApplicationHook;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MapPropertySource;

import javax.swing.*;
import java.util.HashMap;

public class TestRequired {
    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(TestdemoApplication.class){
            @Override
            protected void configureEnvironment(ConfigurableEnvironment environment, String[] args) {
//                environment.getPropertySources().addFirst(new MapPropertySource("myProperties",new HashMap<>(){
//                    {
//                        put("server.port",8080);
//                    }
//                }));
                environment.setRequiredProperties("server.port");
                super.configureEnvironment(environment, args);

            }
        };
        springApplication.run(args);
    }
}
