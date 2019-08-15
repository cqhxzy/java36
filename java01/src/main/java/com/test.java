package com;
import vo.Student;
public class test {
    public static void main(String[] args) {
        Studentlist s=new Studentlist();
        s.add(new Student("1001",1));
        s.add(new Student("1002",2));
        for (Student stu:s) {
            System.out.println(stu.toString());
        }
    }
}
