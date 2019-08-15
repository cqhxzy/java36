package test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @author lz
 * @data 2019-08-14
 * @comment 描述
 */
public class test1 {
    public static void main(String[] args) {
        Class<Student> aclass=Student.class;
        try {
            Constructor<?>[] constructors = aclass.getConstructors();
            for (Constructor<?> constructor : constructors) {
                Class<?>[] parameterTypes = constructor.getParameterTypes();
                for (Class<?> parameterType : parameterTypes) {
                    System.out.print(parameterType.getName()+"    ");
                }

            }
            Constructor<Student> constructor = aclass.getConstructor(String.class, char.class, int.class);
            Student student1 = constructor.newInstance("张三", '男', 18);
            System.out.println(student1);

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
