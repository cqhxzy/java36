package com.hxzy.biz.impl;

import com.hxzy.biz.CourseBiz;
import com.hxzy.dao.CourseDao;
import com.hxzy.dao.impl.CourseDaoImpl;
import com.hxzy.entity.Course;
import com.hxzy.utils.StringUtils;
import com.hxzy.vo.CourseVo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CourseBizImpl implements CourseBiz {
    //导入数据访问层的对象
    private CourseDao dao = new CourseDaoImpl();
    @Override
    public int insert(CourseVo vo) {
        Course course = new Course();
        course.setCourseName(vo.getName());
        course.setModifyDate(StringUtils.convertStr2Date(vo.getDate()));

        return dao.insert(course);
    }

    @Override
    public int update(CourseVo vo) {
        Course course = new Course();
        course.setCourseId(vo.getId());
        course.setCourseName(vo.getName());
        course.setModifyDate(StringUtils.convertStr2Date(vo.getDate()));

        return dao.update(course);
    }

    @Override
    public int delete(Integer id) {
        return dao.delete(id);
    }

    @Override
    public CourseVo findById(Integer id) {
        Course byId = dao.findById(id);
        CourseVo vo = new CourseVo(byId.getCourseId(), byId.getCourseName(), StringUtils.convertDate2Str(byId.getModifyDate()));
        return vo;
    }

    @Override
    public List<CourseVo> queryAll() {
        List<Course> courses = dao.queryAll();

        /*List<CourseVo> list = new ArrayList<>();
        for (Course course : courses) {
            CourseVo vo = new CourseVo(course.getCourseId(), course.getCourseName(), StringUtils.convertDate2Str(course.getModifyDate()));
            list.add(vo);
        }
        return list;*/


        List<CourseVo> collect = courses.parallelStream().map(t -> {
            Integer id = t.getCourseId();
            String name = t.getCourseName();
            String date = StringUtils.convertDate2Str(t.getModifyDate());
            return new CourseVo(id, name, date);
        }).collect(Collectors.toList());

        return collect;
    }
}
