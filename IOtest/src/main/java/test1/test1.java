package test1;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author lz
 * @data 2019-08-12
 * @comment 描述
 */
public class test1 {
    public static void main(String[] args){
        try {
            OutputStream out=new FileOutputStream("D://a.obj");
            ObjectOutputStream oos=new ObjectOutputStream(out);
            List<Student> list=init();

            oos.writeObject(list);
            oos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static List<Student> init(){
        List<Student> list=new ArrayList<>();
        list.add(new Student("张三","男",20));
        list.add(new Student("张四","男",19));
        list.add(new Student("张五","女",17));
        list.add(new Student("张六","女",18));
        return list;
    }
}
