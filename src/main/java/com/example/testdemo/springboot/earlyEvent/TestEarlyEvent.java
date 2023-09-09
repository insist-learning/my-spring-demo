package com.example.testdemo.springboot.earlyEvent;

import org.springframework.context.ApplicationEvent;


public class TestEarlyEvent extends ApplicationEvent {
    public TestEarlyEvent(Object source) {
        super(source);
    }
}
