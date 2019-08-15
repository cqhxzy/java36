package test1;

import test5.Student;

public class StudentDaoTest {
    public static void main(String[] args) {
        String name = "张三";
        StudentDao studentDao = (a,b,c) -> {
            //name = "李四";
            return new Student(name, b, c);
            //return null;
        };

        Student stu = studentDao.getStu("巧巧", 18, '男');

        System.out.println(stu);

    }
}
