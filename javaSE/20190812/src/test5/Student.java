package test5;

import java.io.Serializable;

/**
 * 需要序列化的类，除了实现Serializable接口外，还要提供
 * 一个序列化版本号serialVersionUID
 *
 */
public class Student implements Serializable {

    //通过工具生成的一个序列化的版本号
    private static final long serialVersionUID = 169068705843586132L;

    private String name;
    private int age;
    private char sex;

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
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }
}
