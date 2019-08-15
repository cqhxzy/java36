package test1;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestIntrospector {
    /**
     * java内省机制
     *
     */
    public static void main(String[] args) {
        try {
            /**
             * BeanInfo代表了Student的类
             */
            BeanInfo beanInfo = Introspector.getBeanInfo(Student.class);
            Student student = new Student();

            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
            for (PropertyDescriptor propertyDescriptor : propertyDescriptors) {//PropertyDescriptor描述的就是属性
                //System.out.println(propertyDescriptor.getName());
                if (propertyDescriptor.getName().equals("name")){ //判断是否为name属性
                    Method writeMethod = propertyDescriptor.getWriteMethod(); //writeMethod就是setName方法
                    writeMethod.invoke(student, "张三");
                }
            }

            System.out.println(student);
        } catch (IntrospectionException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
