package com.hxzy.dao;

import com.hxzy.entity.Course;

import java.util.List;

/**
 * 面向接口编程
 * 数据访问层
 */
public interface CourseDao {
    /*
     * 任何一个类都应该包含如下操作
     *
     * */

    /**
     * 新增课程
     * @param course
     * @return
     */
    int insert(Course course);

    /**
     * 根据主键修改
     * @param course
     * @return
     */
    int update(Course course);

    /**
     * 根据主键删除
     * @param id
     * @return
     */
    int delete(Integer id);

    /**
     * 根据主键查询
     * @param id
     * @return
     */
    Course findById(Integer id);

    /**
     * 全查
     * @return
     */
    List<Course> queryAll();
}
