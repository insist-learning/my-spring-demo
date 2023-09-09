package com.example.testdemo.spring;

import com.example.testdemo.TestdemoApplication;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ApplicationEventMulticaster;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

public class TestApplicationEventMulticaster {
    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(TestdemoApplication.class);
        springApplication.run(args);
    }

    public class TestPublishEnent implements InitializingBean {
        @Resource
        private ApplicationEventMulticaster applicationEventMulticaster;

        @Override
        public void afterPropertiesSet() throws Exception {
            applicationEventMulticaster.multicastEvent(new TestEvent("test"));
        }
    }


    public class TestListener implements ApplicationListener<TestEvent> {

        @Override
        public void onApplicationEvent(TestEvent event) {
            System.out.println("event:"+event.getStr());
            System.out.println("eventSource:"+event.getSource());



        }
    }

    public class TestEvent extends ApplicationEvent {

        private String str;

        public TestEvent(Object source) {
            super(source);
            this.str = "hello";
        }

        public String getStr() {
            return str;
        }
    }

}
