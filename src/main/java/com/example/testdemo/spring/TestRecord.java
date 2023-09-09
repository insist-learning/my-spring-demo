package com.example.testdemo.spring;

import java.security.Identity;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TestRecord {
    public static void main(String[] args) {
        record User(String name) {
            public User setName(String name) {
                return new User(name);
            }
        }
        User user = new User("name");
        System.out.println(user.name);
        user = user.setName("name2");
        System.out.println(user.name);
    }
}
