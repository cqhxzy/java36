package test1;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestMethod {
    public static void main(String[] args) {
        Class aClass = Student.class;

        try {
            Object obj = aClass.newInstance();

            //根据方法名和参数列表获取Method
            Method setName = aClass.getMethod("setName", String.class);  //形参，参数的类型

            /**
             * 执行obj对象的setName方法，setName方法需要传递String类型参数
             *
             * invoke方法负责执行Method对应的方法。每个方法都有可能有返回值。
             * 在执行了invode方法后，可以根据方法是否具有返回值来用一个对象接收其值
             * 如果方法返回值类型为void，则不需要接收其值
             */
            setName.invoke(obj, "李四");//实参，类型必须和形参一致

            Method getName = aClass.getMethod("getName");//获取name的方法
            Object invoke = getName.invoke(obj); //用invoke对象接收方法返回值

            System.out.println(invoke);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
