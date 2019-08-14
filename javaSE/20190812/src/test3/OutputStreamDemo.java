package test3;

import java.io.*;

public class OutputStreamDemo {
    public static void main(String[] args) {
        File file = new File("D://b.txt");
        if (!file.exists()){
            try {
                file.createNewFile(); //如果文件不存在，则创建文件
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {
            OutputStream out = new FileOutputStream(file);
            String str = "床前明月光";
            byte[] bytes = str.getBytes();

            for (byte aByte : bytes) {
                out.write(aByte);
            }
            out.close();
            System.out.println("写入文件完毕");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
