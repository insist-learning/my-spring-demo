package com.example.testdemo.springboot.earlyEvent;

import org.springframework.context.ApplicationListener;

public class TestEarlyEventListener implements ApplicationListener<TestEarlyEvent> {
    @Override
    public void onApplicationEvent(TestEarlyEvent event) {
        System.out.println("this is early Event"+event.getSource());
    }
}
