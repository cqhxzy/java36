package day2.db;

import day2.entity.Student;
import org.junit.Test;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

public class StudentDbManagerTest {

    @Test
    public void insert() {
        StudentDbManager manager = new StudentDbManager();

        //组件学生对象
        Student student = new Student(0, 6, "454524195263214566", "200523164754007", "zhangsan", "重庆", 88.0);
        //调用插入学生的方法，将实体对象传递到插入的方法
        int insert = manager.insert(student); //得到数据库受影响的行数

        //断言，insert的值比0大
        assertThat(insert, greaterThan(0));
    }

    @Test
    public void update() {
        StudentDbManager manager = new StudentDbManager();

        //组件学生对象
        Student student = new Student(8, 6, "454524195263214566", "200523164754007", "张三", "重庆", 88.0);

        int update = manager.update(student);

        //断言，insert的值比0大
        assertThat(update, greaterThan(0));
    }

    @Test
    public void delete() {
        StudentDbManager manager = new StudentDbManager();
        int delete = manager.delete(7);

        //断言，insert的值比0大
        assertThat(delete, greaterThan(0));
    }

    @Test
    public void queryAll() {
        StudentDbManager manager = new StudentDbManager();
        List<Student> students = manager.queryAll();

        students.stream().forEach(System.out::println);
    }

    @Test
    public void queryByExamCard() {
        StudentDbManager manager = new StudentDbManager();
        List<Map<String, Object>> list = manager.queryByExamCard("200523164754005");

        list.stream().forEach(t->{   //t代表每次循环的Map集合
            Set<String> keys = t.keySet();  //得到当前map集合的键的集合

            for (String key : keys) { //遍历键的集合
                Object value = t.get(key); //根据键获取值
                System.out.println("key:" + key + ", value:" + value);
            }
            System.out.println();
        });
    }

    @Test
    public void queryByIdCard() {
        StudentDbManager manager = new StudentDbManager();
        List<Map<String, Object>> list = manager.queryByIdCard("100824195263214584");
        list.stream().forEach(t->{
            Set<String> keys = t.keySet();

            for (String key : keys) {
                Object value = t.get(key);
                System.out.println("key:" + key + ", value:" + value);
            }
            System.out.println();
        });
    }
}