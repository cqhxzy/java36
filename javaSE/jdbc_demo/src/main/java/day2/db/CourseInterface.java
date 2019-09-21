package day2.db;

import day2.entity.Course;

import java.util.List;
import java.util.Map;

public interface CourseInterface {
    int insert(Course course);

    int update(Course course);

    int delete(Integer courseId);

    Course findById(Integer courseId);

    List<Map<String, Object>> queryAll();
}
