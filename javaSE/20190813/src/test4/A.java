package test4;

public class A {
    static{
        //在类的字节码加载到方法区后，就会执行的代码块
        System.out.println("A的静态代码块被执行了");
    }
    {
        System.out.println("A的实例代码块被执行了");
    }
    public A() {
        System.out.println("A的构造方法被执行");
    }
}
