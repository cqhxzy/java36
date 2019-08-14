package test2;

import java.util.Date;
import java.util.TimeZone;

public class Test1 {
    public static void main(String[] args) {
        Date date = new Date();//获取系统当前时间
        System.out.println(date);
        System.out.println(date.getTime());

        Date d2 = new Date(0);
        System.out.println(d2);


    }
}
