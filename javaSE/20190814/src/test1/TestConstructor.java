package test1;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class TestConstructor {
    public static void main(String[] args) {
        //1.获取类的Class对象
        try {
            Class aClass = Class.forName("test1.Student");

            /*Constructor[] constructors = aClass.getConstructors();
            for (Constructor constructor : constructors) {
                System.out.println("获取当前构造函数的信息");
                int parameterCount = constructor.getParameterCount();//构造函数参数列表的个数
                System.out.println("构造函数参数个数：" + parameterCount);

                Class[] parameterTypes = constructor.getParameterTypes();//获取所有参数的类型
                System.out.println("当前构造函数参数列表:");
                for (Class parameterType : parameterTypes) {
                    System.out.print(parameterType.getName() + "    ");
                }

            }*/

            //在明确了构造函数参数列表后，可以直接通过参数列表获取构造函数的对象
            Constructor constructor = aClass.getConstructor(String.class, int.class, char.class);

            //通过构造函数实例化对象
            Object o = constructor.newInstance("张三", 18, '男');
            System.out.println(o);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
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
