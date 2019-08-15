package test2;

import java.io.*;

public class BufferedReaderDemo1 {
    public static void main(String[] args) {
        try {
            Reader reader = new FileReader("D://a.txt");
            BufferedReader bufferedReader = new BufferedReader(reader); //BufferedReader包装了Reader

            String str = null;
            while ((str = bufferedReader.readLine()) != null) {
                System.out.println(str);
            }

            bufferedReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
