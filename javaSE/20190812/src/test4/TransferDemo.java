package test4;

import java.io.*;

/**
 * 转换流
 * 将字节流转换为字符流
 */
public class TransferDemo {
    public static void main(String[] args) {
        try {
            InputStream in = new FileInputStream("D://a.txt"); //字节输入流
            //字符输入流，充当的是将字节输入流转换为字符输入流
            InputStreamReader isr = new InputStreamReader(in, "utf-8");

            BufferedReader buffer = new BufferedReader(isr);//将字符流用缓存流包装起来

            String str = null;
            while ((str = buffer.readLine()) != null) {
                System.out.println(str);
            }

            buffer.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
