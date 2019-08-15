package test1;

public class Test1 {
    public static void main(String[] args) {
        //通过类名.class
        Class<Student> stu_class = Student.class;
        System.out.println(stu_class);

        //通过对象.getClass()
        /*Student student = new Student();
        Class<? extends Student> aClass = student.getClass();
        System.out.println(aClass);*/
        try {
            Class<?> aClass1 = Class.forName("test1.Student");

            System.out.println(aClass1);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            Student student1 = stu_class.newInstance(); //通过反射实例化的对象
            System.out.println(student1);

        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
