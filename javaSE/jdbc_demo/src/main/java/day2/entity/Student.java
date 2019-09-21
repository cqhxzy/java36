package day2.entity;

import java.util.Objects;

/**
 * Student类对应数据库中的examstudent表
 */
public class Student {

    private Integer flowId;
    private Integer type;
    private String idCard;
    private String examCard;
    private String studentName;
    private String location;
    private Double grade;

    public Student() {
    }

    public Student(Integer flowId, Integer type, String idCard, String examCard, String studentName, String location, Double grade) {
        this.flowId = flowId;
        this.type = type;
        this.idCard = idCard;
        this.examCard = examCard;
        this.studentName = studentName;
        this.location = location;
        this.grade = grade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(flowId, student.flowId) &&
                Objects.equals(idCard, student.idCard) &&
                Objects.equals(examCard, student.examCard);
    }

    @Override
    public int hashCode() {
        return Objects.hash(flowId, idCard, examCard);
    }

    @Override
    public String toString() {
        return "Student{" +
                "flowId=" + flowId +
                ", type=" + type +
                ", idCard='" + idCard + '\'' +
                ", examCard='" + examCard + '\'' +
                ", studentName='" + studentName + '\'' +
                ", location='" + location + '\'' +
                ", grade=" + grade +
                '}';
    }

    public Integer getFlowId() {
        return flowId;
    }

    public void setFlowId(Integer flowId) {
        this.flowId = flowId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getExamCard() {
        return examCard;
    }

    public void setExamCard(String examCard) {
        this.examCard = examCard;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Double getGrade() {
        return grade;
    }

    public void setGrade(Double grade) {
        this.grade = grade;
    }
}
