package test2;



import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author lz
 * @data 2019-08-12
 * @comment 描述
 */
public class Cut{

    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        System.out.println("请输入要剪切的文件路径：");
        String or=input.next();
        System.out.println("请输入要剪切到的文件路径：");
        String dest=input.next();
        System.out.println(cut(or,dest)?"剪切成功！":"剪切失败！");
    }
    private static boolean cut(String origion,String dest){
        try {
            Reader reader=new FileReader(origion);
            List<Character> list=new ArrayList<>();
            int i = -1;
            while((i = reader.read()) != -1) {
                char c = (char) i;
                list.add(c);
            }
            reader.close();
            Writer writer=new FileWriter(dest);
            for (char c:list) {
                writer.write(c);
            }
            writer.close();
            File file =new File(origion);
            file.delete();

            System.out.println("文件剪切完成");
            return true;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}
