package test5;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        try {
            OutputStream out = new FileOutputStream("D://students.obj");
            ObjectOutputStream oos = new ObjectOutputStream(out);

            //将集合写入文件
            List<Student> init = init();
            oos.writeObject(init); //序列化

            oos.close();
            System.out.println("写出文件完毕");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static List<Student> init(){
        List<Student> list = new ArrayList<>();

        list.add(new Student("test1", 18, '男'));
        list.add(new Student("test2", 17, '女'));
        list.add(new Student("test3", 19, '男'));
        list.add(new Student("test4", 15, '女'));
        list.add(new Student("test5", 13, '男'));

        return list;
    }
}
