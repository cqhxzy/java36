package com.hxzy.entity;

import com.hxzy.vo.CourseVo;

import java.util.Date;

/**
 * 课程类，对应数据库中tab_course表
 */
public class Course{
    private Integer courseId;
    private String courseName;
    private Date modifyDate;

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }


    @Override
    public String toString() {
        return "Course{" +
                "courseId=" + courseId +
                ", courseName='" + courseName + '\'' +
                ", modifyDate=" + modifyDate +
                '}';
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }


    public Course() {
    }

    public Course(Integer courseId, String courseName, Date modifyDate) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.modifyDate = modifyDate;
    }

}
