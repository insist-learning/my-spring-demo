package com.example.testdemo.springboot;

import java.util.HashMap;
import java.util.Map;

public class MergeMap
{
    private static Map<String, String> defaultMap = new HashMap<>();
    static {
        defaultMap.put("key1", "value1");
        defaultMap.put("key2", "value2");
    }

    private static Map<String, String> newMap = new HashMap<>();
    static {
        newMap.put("key1", "newKey1");
        newMap.put("key3", "key3");
    }

    public static void main(String[] args) {
        Map<String,String> mergeMap = new HashMap<>(defaultMap);
        mergeMap.putAll(newMap);
        System.out.println(mergeMap);
    }
}
