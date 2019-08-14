package test1;

public class Test1 {
    // shift + enter  使光标自动切换到花括号以内

    public static void main(String[] args) {
        Test1 test1 = new Test1();
        /*
        * final关键字
        * final修饰变量：常量，常量一旦声明就必须赋值，赋值后只能取值而不能改值。常量命名规范：大写，多个单词之间
        *           以下划线分隔：
        *               普通的成员变量按照驼峰命名法： stuName
        *               常量：   final int MAX_AGE = 28;
        * final修饰类：被修饰的类不能被子类继承
        * final修饰方法：被修饰的方法不能被子类重写
        *
        * */
        Test1 test2 = new Test1();
        boolean equals = test1.equals(test2);

        System.out.println(test1.hashCode());
        System.out.println(test2.hashCode());
        System.out.println("内存地址：" + test1);
        System.out.println("hashcode转换后的内存地址：" + Integer.toHexString(test1.hashCode())); //Integer.toHexString(test1.hashCode()) 将对象的hashcode转换为十六进制的字符串
    }
}
