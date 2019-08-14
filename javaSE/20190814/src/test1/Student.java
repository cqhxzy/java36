package test1;

import java.io.Serializable;

public class Student extends Human implements Serializable,Cloneable{
    private static final long serialVersionUID = -6261378201869376044L;
    private String name;
    private int age;
    private char sex;

    public String address;

    String phone;
    protected String QQ;

    public Student() {
    }

    public Student(String name, int age, char sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        System.out.println("执行setName");
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        System.out.println("执行setAge");
        this.age = age;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        System.out.println("执行setSex");
        this.sex = sex;
    }

    private void test(){

    }
}
