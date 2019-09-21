package com.wisezone;

import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;

public class Test {
    public static void main(String[] args) {
        try {
            Class<?> user = Class.forName("com.wisezone.User");

            Object o = user.newInstance();

            BeanUtils.setProperty(o, "name", "张三");
            BeanUtils.setProperty(o, "age", 20);

            System.out.println(o);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
