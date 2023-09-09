package com.example.testdemo.springboot;

public class TestShutdownHook {
    public static void main(String[] args) {
        Runtime.getRuntime().addShutdownHook(new Thread(()->{
            System.out.println("触发程序终止钩子");
        }));
        System.out.println("程序执行完");
    }
}
