package test5;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.util.List;

public class Test2 {
    public static void main(String[] args) {

        try {
            InputStream in = new FileInputStream("D://students.obj");
            ObjectInputStream ois = new ObjectInputStream(in);

            List<Student> list = (List<Student>) ois.readObject();//反序列化

            for (Student student : list) {
                System.out.println(student);
            }

            ois.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
