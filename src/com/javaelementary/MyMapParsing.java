package com.javaelementary;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MyMapParsing {
    public static void parse(Map<String, String> map, Student student) {
        List<Map.Entry<String, String>> list = new ArrayList<>(map.entrySet());
        try {
            for (int i = 0; i < list.size(); i++) {
                Field field = student.getClass().getDeclaredField(list.get(i).getKey());
                Class fieldType = field.getType();
                //if (field.getName().equals(list.get(i).getKey())){
                field.setAccessible(true);
                switch (fieldType.getName()) {
                    case "int":
                        field.set(student, Integer.parseInt(list.get(i).getValue()));
                        break;
                    case "double":
                        field.set(student, Double.parseDouble(list.get(i).getValue()));
                        break;
                    case "long":
                        field.set(student, Long.parseLong(list.get(i).getValue()));
                        break;
                    case "byte":
                        field.set(student, Byte.parseByte(list.get(i).getValue()));
                        break;
                    case "boolean":
                        field.set(student, Boolean.parseBoolean(list.get(i).getValue()));
                        break;
                    default:
                        field.set(student, list.get(i).getValue());
                        break;
                }
                field.setAccessible(false);
            }
        } catch (NoSuchFieldException | IllegalAccessException e) {
            System.out.println("Field not found");
        }
    }
}