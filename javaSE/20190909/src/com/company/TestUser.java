package com.company;

import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;

public class TestUser {
    public static void main(String[] args) {
        User user = new User();

        try {
            Class<?> userClass = Class.forName("com.company.User");
            Object obj = userClass.newInstance();

            //通过apache的commons-beanutils这个jar包，反射+内省实现为对象赋值

            BeanUtils.setProperty(obj, "name", "张三");
            BeanUtils.setProperty(obj,"age",18);

            System.out.println(obj);

        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
