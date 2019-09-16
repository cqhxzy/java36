package com.hxzy.dao.impl;

import com.hxzy.dao.CourseDao;
import com.hxzy.entity.Course;
import com.hxzy.utils.DbUtils;

import java.util.List;

public class CourseDaoImpl extends DbUtils implements CourseDao {
    @Override
    public int insert(Course course) {
        String sql = "insert into tab_course (courseName,modifyDate) values(?,?)";

        return super.executeUpdate(sql,course.getCourseName(),course.getModifyDate());
    }

    @Override
    public int update(Course course) {
        String sql = "update tab_course set courseName = ?,modifyDate=? where courseId = ?";

        return super.executeUpdate(sql,course.getCourseName(),course.getModifyDate(), course.getCourseId());
    }

    @Override
    public int delete(Integer id) {
        String sql = "delete from tab_course where courseId = ?";

        return super.executeUpdate(sql, id);
    }

    @Override
    public Course findById(Integer id) {
        String sql = "select courseId,courseName,modifyDate from tab_course where courseId = ?";
        List<Course> courses = super.queryAll(Course.class, sql, id);

        return courses.size() > 0 ? courses.get(0) : null;
    }

    @Override
    public List<Course> queryAll() {
        String sql = "select courseId,courseName,modifyDate from tab_course";
        return super.queryAll(Course.class, sql);
    }
}
