package com.hxzy.vo;

public class CourseVo {
    private Integer id;
    private String name;
    private String date;

    public CourseVo() {
    }

    public CourseVo(Integer id, String name, String date) {
        this.id = id;
        this.name = name;
        this.date = date;
    }

    @Override
    public String toString() {
        return "CourseVo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", date='" + date + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
