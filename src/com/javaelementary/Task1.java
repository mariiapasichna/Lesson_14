package com.javaelementary;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class Task1 {

    /*
    1) Написать класс в котором есть 4 метода: +-/*
    Которые принимают 2 параметра типа int.
    Нужно написать метод который по строковому имени метода найдет его и вызовет, при помощи Reflection.
    Если такого метода нет выдать ошибку.
    */

    public static void main(String[] args) {
        findMethod("sum", 12, 23);
    }

    private static boolean findMethod(String methodName, int a, int b) {
        Class clazz = Calculator.class;
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            if (method.getName().equals(methodName)) {
                System.out.println(Arrays.toString(method.getParameterTypes()));
                try {
                    double result = (double) method.invoke(clazz, a, b);
                    System.out.println(result);
                    return true;
                } catch (InvocationTargetException | IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        try {
            throw new NoSuchMethodException();
        } catch (NoSuchMethodException e) {
            System.out.println("Method " + methodName + " not found");
        }
        return false;
    }
}