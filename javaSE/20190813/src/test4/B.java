package test4;

public class B extends A{
    static{
        System.out.println("B的静态代码块被执行了");
    }
    {
        System.out.println("B的实例代码块被执行了");
    }
    public B() {
        super();
        System.out.println("B的构造方法被执行了");
    }
}
