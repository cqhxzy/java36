package test3;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Test {
    public static void main(String[] args) {
        test1();
        //test2();
    }

    /**
     * 将日期转换为字符串
     */
    private static void test1(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd HH:mm:ss  D Y w W E a S");
        Date date = new Date(); //当前时间
        String format = sdf.format(date);
        System.out.println(format);
    }

    /**
     * 将字符串的日期还原为日期的对象
     */
    private static void test2(){
        String date_str = "2010-5-5";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date = sdf.parse(date_str); //将字符串日期转换为Date的对象

            Calendar instance = Calendar.getInstance();
            instance.setTime(date);

            int year = instance.get(Calendar.YEAR);
            int month = instance.get(Calendar.MONTH) + 1;
            int d = instance.get(Calendar.DATE);

            System.out.println(year + "-" + month + "-" + d);

        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
