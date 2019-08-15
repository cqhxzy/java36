package test1;

import java.io.*;
import java.util.List;

/**
 * @author lz
 * @data 2019-08-12
 * @comment 描述
 */
public class test2 {
    public static void main(String[] args) {
        try {
            InputStream in=new FileInputStream("D://a.obj");
            ObjectInputStream ois=new ObjectInputStream(in);

            List<Student> list = (List<Student>) ois.readObject();

            for (Student s:list) {
                System.out.println(s);
            }
            ois.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
