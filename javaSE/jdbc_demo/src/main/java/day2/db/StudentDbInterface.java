package day2.db;

import day2.entity.Student;

import java.util.List;
import java.util.Map;

public interface StudentDbInterface {
    /*添加学生*/
    int insert(Student student);

    /*根据主键修改学生信息*/
    int update(Student student);

    /**
     * 根据主键删除学生信息
     * @param flowId
     * @return
     */
    int delete(Integer flowId);

    /**
     * 全查
     * @return
     */
    List<Student> queryAll();

    /**
     * 根据准考证查询考试信息
     * @param examCard
     * @return
     */
    List<Map<String,Object>> queryByExamCard(String examCard);

    /**
     * 根据身份证号查询成绩
     * @param idCard
     * @return
     */
    List<Map<String,Object>> queryByIdCard(String idCard);
}
