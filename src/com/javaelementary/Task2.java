package com.javaelementary;

import java.util.LinkedHashMap;
import java.util.Map;

public class Task2 {
    public static void main(String[] args) {
        Map<String, String> map = new LinkedHashMap<>();
        map.put("name", "Alex");
        map.put("age", "22");
        map.put("group", "java");
        map.put("dateOfStart", "22.01.2020");
        Student student = new Student();
        MyMapParsing.parse(map, student);
        System.out.println(student);
    }
}