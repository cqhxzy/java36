package com.lz;
import org.junit.Test;
import java.io.File;
/**
 * @author lz
 * @data 2019-08-09
 * @comment 描述
 */

public class IO1Test {

    @Test
    public void testFile01(){
        File file=new File("E:\\chrome");
        File[] childFile=file.listFiles();
        for (File file01:childFile) {
            if(file01.isFile()){
                System.out.println("- "+file01.getName());
            }else{
                System.out.println("D "+file01.getName());
                printFile(file01,1);
            }
        }

    }
    @Test
    public void printFile(File file,int index){
        StringBuffer sb=new StringBuffer();
        for(int i=0;i<index;i++){
            sb.append("\t");
        }
        File[] file1=file.listFiles();
        for (File file01:file1) {
            if(file01.isFile()){
                System.out.println(sb.toString()+"- "+file01.getName());
            }else{
                System.out.println(sb.toString()+"D "+file01.getName());
                printFile(file01,index+1);
            }
        }
    }
}
