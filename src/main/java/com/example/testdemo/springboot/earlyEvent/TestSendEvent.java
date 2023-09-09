package com.example.testdemo.springboot.earlyEvent;

import com.example.testdemo.TestdemoApplication;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.event.ApplicationEventMulticaster;
import org.springframework.stereotype.Component;

@Component
public class TestSendEvent implements InitializingBean {

    @Resource
    private ApplicationEventMulticaster applicationEventMulticaster;

    @Override
    public void afterPropertiesSet() throws Exception {
        applicationEventMulticaster.multicastEvent(new TestEarlyEvent("myevent-data"));
    }

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(TestdemoApplication.class){
            @Override
            protected ConfigurableApplicationContext createApplicationContext() {
                return super.createApplicationContext();
            }
        };
        springApplication.run(args);
    }
}
