package test1;

import java.util.Objects;

public class Student {
    private String idCard;
    private String name;

    public Student(String idCard,String name) {
        this.idCard = idCard;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(idCard, student.idCard) &&
                Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCard, name);
    }

    @Override
    public String toString() {
        return "学生{" +
                "身份证='" + idCard + '\'' +
                ", 姓名='" + name + '\'' +
                '}';
    }
}
