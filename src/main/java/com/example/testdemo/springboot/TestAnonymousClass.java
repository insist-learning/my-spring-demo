package com.example.testdemo.springboot;

import java.util.ArrayList;
import java.util.List;

public class TestAnonymousClass {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>(){
            {
                add("user1");
                add("user2");
            }

            @Override
            public boolean add(String s) {
                System.out.println("添加元素:"+s);
                return super.add(s);
            }
        };

    }

    static class AnoClass {
        private String name;
        // 动态代码块，创建对象前执行
        {
            System.out.println("动态代码块");
        }
        // 静态代码快
        static {
            System.out.println("静态代码块");
        }

        public AnoClass(String name) {
            System.out.println("构造函数");
            this.name = name;
        }


        public String getName() {
            return name;
        }
    }
}
