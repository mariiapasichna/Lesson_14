package com.javaelementary;

import java.util.LinkedHashMap;
import java.util.Map;

public class Task2 {
    public static void main(String[] args) {
        Map<String, String> map = new LinkedHashMap<>();
        map.put("name", "Alex");
        map.put("age", "22");
        Student student = new Student();
        MyMapParsing.parse(map, student);
        System.out.println(student);
    }
}