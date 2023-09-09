package com.example.testdemo.spring;

public enum TestEnum {
    red,green

    ;

    private Boolean isColor(String name) {
        return name().equals(name);
    }

    public static void main(String[] args) {
        Boolean red1 = TestEnum.red.isColor("red");
        System.out.println(red1);

    }
}
