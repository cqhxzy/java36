package test1;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Test2 {
    public static void main(String[] args) {
        Class<Student> aClass = Student.class;

        //获取Class中的类的完整名称
        String aClassName = aClass.getName();
        System.out.println(aClassName); //test1.Student     包名.类名     =>   类的完整路径


        //获取父类
        Class<? super Student> superclass = aClass.getSuperclass();
        String superclassName = superclass.getName();
        System.out.println(superclassName); //java.lang.Object

        //获取接口
        Class<?>[] interfaces = aClass.getInterfaces(); //java是单继承，多实现
        for (Class<?> anInterface : interfaces) {
            //anInterface 代表当前实现的接口
            String anInterfaceName = anInterface.getName();
            System.out.println("实现的接口：" + anInterfaceName);
        }

        //获取所有的构造函数
        Constructor<?>[] constructors = aClass.getConstructors();
        System.out.println("构造函数的个数：" + constructors.length);

        //获取所有公共的或者父类中公共的属性
        Field[] fields = aClass.getFields();
        System.out.println("所有公共的及父类中属性的个数：" + fields.length);

        //获取本类中所有的属性（包括私有的，默认的，功受保护的，公共的）
        Field[] declaredFields = aClass.getDeclaredFields();
        System.out.println("所有属性：" + declaredFields.length);
        for (Field declaredField : declaredFields) {
            System.out.println(declaredField.getName()); //获取属性名
        }

        //获取本类中公共的及父类中公共的方法
        Method[] methods = aClass.getMethods();
        System.out.println("所有的公共的方法的个数：" + methods.length);

        Method[] declaredMethods = aClass.getDeclaredMethods();


    }
}
