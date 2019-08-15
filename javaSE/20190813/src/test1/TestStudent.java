package test1;

public class TestStudent {
    public static void main(String[] args) {
        Student student1 = new Student("123456789","张三");
        Student student2 = new Student("123456789","张三");
        //System.out.println("hashcode:" + student.hashCode()); //1163157884

        System.out.println(student1 == student2); //内存地址不同
        System.out.println(student1.hashCode() == student2.hashCode());
        System.out.println(student1);
    }
}
