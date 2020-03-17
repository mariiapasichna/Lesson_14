package com.javaelementary;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MyMapParsing {
    public static void parse(Map<String, String> map, Student student) {
        List<Map.Entry<String, String>> list = new ArrayList<>(map.entrySet());
        List<Map.Entry<String, String>> listForRecord = new ArrayList<>();
        Field[] fields = student.getClass().getDeclaredFields();
        for (int i = 0; i < list.size(); i++) {
            for (Field field : fields) {
                if (field.getName().equals(list.get(i).getKey())) {
                    listForRecord.add(list.get(i));
                }
            }
        }
        try {
            for (int i = 0; i < listForRecord.size(); i++) {
                Field field = student.getClass().getDeclaredField(listForRecord.get(i).getKey());
                Class fieldType = field.getType();
                field.setAccessible(true);
                switch (fieldType.getName()) {
                    case "int":
                        field.set(student, Integer.parseInt(listForRecord.get(i).getValue()));
                        break;
                    case "double":
                        field.set(student, Double.parseDouble(listForRecord.get(i).getValue()));
                        break;
                    case "float":
                        field.set(student, Float.parseFloat(listForRecord.get(i).getValue()));
                        break;
                    case "long":
                        field.set(student, Long.parseLong(listForRecord.get(i).getValue()));
                        break;
                    case "byte":
                        field.set(student, Byte.parseByte(listForRecord.get(i).getValue()));
                        break;
                    case "boolean":
                        field.set(student, Boolean.parseBoolean(listForRecord.get(i).getValue()));
                        break;
                    case "java.lang.String":
                        field.set(student, listForRecord.get(i).getValue());
                        break;
                    default:
                        System.out.println("Unexpected type: " + fieldType.getName());
                        break;
                }
                field.setAccessible(false);
            }
        } catch (NoSuchFieldException | IllegalAccessException e) {
            System.out.println("Field not found");
        }
    }
}