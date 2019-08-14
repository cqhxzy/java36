package test1;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class TestFeild {
    public static void main(String[] args) {
        Class aClass = Student.class;

        //test1(aClass);

        test2(aClass);
    }

    /**
     * 操作私有的属性
     * @param aClass
     */
    private static void test2(Class aClass){
        try {
            Object obj = aClass.newInstance();

            Field name = aClass.getDeclaredField("name"); //获取私有的属性name
            //System.out.println(name);

            //设置私有属性的可见性
            name.setAccessible(true);

            name.set(obj, "张三");

            Object o = name.get(obj);
            System.out.println(o);
            //System.out.println(obj);

            name.setAccessible(false);

        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    /**
     * 操作公共的属性
     * @param aClass
     */
    private static void test1(Class aClass) {
        try {
            //通过newInstance方法创建一个默认的对象
            Object obj = aClass.newInstance();

            Field address = aClass.getField("address"); //仅能够获取公共的属性

            //获取访问修饰符
            int modifiers = address.getModifiers();
            System.out.println("address访问修饰符：" + Modifier.toString(modifiers));

            //获取属性的类型
            Class<?> type = address.getType();
            System.out.println("address的类型：" + type.getName());

            //System.out.println(address);

            address.set(obj, "重庆市渝中区"); //为obj对象的address属性赋值为重庆市渝中区

            //取值操作
            Object value = address.get(obj);//获取obj对象的address属性的值

            System.out.println(value);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }
}
