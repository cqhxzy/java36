package vo;

public class Student {
    private String id;
    private int num;

    public Student(String id, int num) {
        this.id = id;
        this.num = num;
    }

    public Student() {
    }

    public String getId() {
        return id;
    }

    public int getNum() {
        return num;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setNum(int num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "Student{" +
                "学号='" + id + '\'' +
                ", 编号=" + num +
                '}';
    }
}
