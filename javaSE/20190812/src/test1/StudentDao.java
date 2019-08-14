package test1;

import test5.Student;

public interface StudentDao {
    //根据参数，将参数实例化为一个学生的对象
     Student getStu(String name,int age,char sex);
}
