package test4;

import java.io.*;

public class TransferDemo2 {
    public static void main(String[] args) {
        try {
            OutputStream out = new FileOutputStream("D://b.txt");//字节输出流
            OutputStreamWriter osw = new OutputStreamWriter(out);//字符输出流

            BufferedWriter buffer = new BufferedWriter(osw);

            buffer.write("和品共处，不要港独");

            buffer.close();
            System.out.println("写出文件完毕");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
