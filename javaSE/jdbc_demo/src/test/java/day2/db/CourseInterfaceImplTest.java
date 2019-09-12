package day2.db;

import day2.entity.Course;
import org.junit.Test;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.junit.Assert.*;

public class CourseInterfaceImplTest {

    @Test
    public void insert() {
    }

    @Test
    public void update() {
    }

    @Test
    public void delete() {
    }

    @Test
    public void findById() {
        CourseInterfaceImpl impl = new CourseInterfaceImpl();
        Course course = impl.findById(2);
        System.out.println(course);
    }

    @Test
    public void queryAll() {
        CourseInterfaceImpl impl = new CourseInterfaceImpl();
        List<Map<String, Object>> list = impl.queryAll();

        for (Map<String, Object> map : list) {
            Set<Map.Entry<String, Object>> entries = map.entrySet();
            for (Map.Entry<String, Object> entry : entries) {
                String key = entry.getKey();
                Object value = entry.getValue();

                System.out.println("key:" + key + ",  value:" + value);
            }

            System.out.println();
        }

    }
}