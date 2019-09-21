package day2.db;

import day2.entity.Course;
import day2.util.DbUtils;

import java.util.List;
import java.util.Map;

public class CourseInterfaceImpl extends DbUtils implements CourseInterface {

    @Override
    public int insert(Course course) {
        String sql = "insert into tab_course(courseName) values (?)";

        return super.executeUpdate(sql, course.getCourseName());
    }

    @Override
    public int update(Course course) {
        String sql = "update tab_course set courseName = ? where courseId = ?";

        return super.executeUpdate(sql,course.getCourseName(),course.getCourseId());
    }

    @Override
    public int delete(Integer courseId) {
        String sql = "delete from tab_course where courseId = ?";

        return super.executeUpdate(sql, courseId);
    }

    @Override
    public Course findById(Integer courseId) {
        String sql = "select courseId,courseName,modifyDate from tab_course where courseId = ?";
        /*List<Map<String, Object>> list = super.executeQuery1(sql, courseId);
        if (list.size() <= 0) {
            return null;  //没有这个id对应的数据
        }
        Map<String, Object> stringObjectMap = list.get(0);
        Object courseId1 = stringObjectMap.get("courseId");
        Object courseName = stringObjectMap.get("courseName");

        return new Course((Integer) courseId1, (String) courseName);*/

        List<Course> courses = super.queryAll(Course.class, sql, courseId);

        return courses.size() > 0 ? courses.get(0) : null;
    }

    @Override
    public List<Map<String, Object>> queryAll() {
        String sql = "select courseId,courseName from tab_course";

        return super.executeQuery1(sql);
    }
}
