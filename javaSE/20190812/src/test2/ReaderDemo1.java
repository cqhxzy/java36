package test2;

import java.io.*;

public class ReaderDemo1 {
    public static void main(String[] args) {
        //readInputStream();
        //readReader();
    }

    public static void readReader(){
        try {
            Reader reader = new FileReader("D://a.txt");
            int i = -1;
            while((i = reader.read()) != -1){
                char c = (char)i;
                System.out.println(c);
            }

            reader.close(); //关闭输入流
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void readInputStream() {
        try {
            InputStream in = new FileInputStream("D://a.txt");
            int i = -1;
            while ((i = in.read()) != -1) {
                //i就是每次读到的字节
                char c = (char)i;
                System.out.println(c);
            }

            in.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
