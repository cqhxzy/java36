package test3;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class WriterDemo {
    public static void main(String[] args) {
        try {
            Writer writer = new FileWriter("D://b.txt");
            String str = "欢迎大家学习JAVA SE课程";

           /* writer.write(str);

            writer.close();*/

            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            bufferedWriter.write(str);

            bufferedWriter.flush(); //刷新缓存
            bufferedWriter.close(); //关闭输出流
            System.out.println("写入文件完毕");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
