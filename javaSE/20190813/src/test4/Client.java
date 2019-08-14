package test4;

public class Client {
    public static void main(String[] args) {
        //B b = new B();
        try {
            //通过类加载器，仅加载B类的数据结构到内存中。这个时候根本就不存在实例化对象的概念
            Class.forName("test4.B");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
