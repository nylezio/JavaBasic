package com.codejerry.反射;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author: codeJerry
 * @description:
 * @date: 2020/07/11 12:58
 */
public class Sample {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException,
            InstantiationException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        Class rc = Class.forName("com.codejerry.反射.Robot");
        Robot r = (Robot) rc.newInstance();
        System.out.println(rc.getName());
        r.sayHi("bob");
        Method getHello = rc.getDeclaredMethod("throwHello", String.class);
        getHello.setAccessible(true);
        Object str = getHello.invoke(r, "bob");
        System.out.println("getHello result is " + str);
        Method sayHi = rc.getMethod("sayHi", String.class);
        sayHi.invoke(r,"ruby");
        Field name = rc.getDeclaredField("name");
        name.setAccessible(true);
        name.set(r, "Alcie");
        sayHi.invoke(r, "welcome");
    }
}
