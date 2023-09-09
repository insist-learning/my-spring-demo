package com.example.testdemo.springboot;

import org.junit.Test;

public class TestFinalClass {


    public TestFinalClass() {

    }

    private String name;



    TestFinalClass(String name) {
        this.name = name;
        Data data = new Data();
        // 在类的内部引用内部类，可以获取当前实例的数据
        System.out.println(data.getName());
    }


    class Data{
        public String getName() {
            return TestFinalClass.this.name;
        }
    }





    @Test
    public void testGet() {
        TestFinalClass tf = new TestFinalClass("username");
    }


}
