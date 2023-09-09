package com.example.testdemo.spring;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class TestClassLoader {
    public static void main(String[] args) throws IOException {

        InputStream resourceAsStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("test.text");
        byte[] bytes = resourceAsStream.readAllBytes();
        System.out.println(new String(bytes));

//        System.out.println(Thread.currentThread().getC);




    }
}
