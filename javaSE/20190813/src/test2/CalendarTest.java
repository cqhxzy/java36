package test2;

import java.time.Month;
import java.util.Calendar;

public class CalendarTest {
    public static void main(String[] args) {
        Calendar instance = Calendar.getInstance(); //获取系统当前时间
        /*instance.set(Calendar.YEAR,2018);
        instance.set(Calendar.MONTH,Calendar.APRIL);

        int actualMaximum = instance.getActualMaximum(Calendar.DATE);//获取这个月的最大天数
        System.out.println("这个月的最大天数：" + actualMaximum);*/

        //instance.set(Calendar.DATE,29);
        
        //instance.clear(); //清空Calendar
        //instance.set(2000,5,28);
        instance.set(Calendar.DATE,15);
        print(instance);
    }

    private static void print(Calendar instance){
        final String[] weeks = {"星期天","星期一","星期二","星期三","星期四","星期五","星期六"};
        int year = instance.get(Calendar.YEAR); //得到年份
        //Calendar.MONTH 取值范围时0—11.  0代表一月，11代表12月
        int month = instance.get(Calendar.MONTH) + 1; //实际月份

        int date = instance.get(Calendar.DATE); //获取日期

        int hour_12 = instance.get(Calendar.HOUR); //12小时制的hour
        int am_pm = instance.get(Calendar.AM_PM);// 返回0：上午，返回1：下午
        String am_pm_str = am_pm == 0 ? "AM" : "PM";

        int hour_24 = instance.get(Calendar.HOUR_OF_DAY); //24小时制的hour
        int minute = instance.get(Calendar.MINUTE);
        int seconde = instance.get(Calendar.SECOND);

        int week = instance.get(Calendar.DAY_OF_WEEK); // 1 - 7  1：星期天  7星期六
        int dayOfMonth = instance.get(Calendar.DAY_OF_MONTH);
        int week_of_month = instance.get(Calendar.WEEK_OF_MONTH);
        int day_of_year = instance.get(Calendar.DAY_OF_YEAR); //这个日期是这年的多少天
        int day_of_week_in_month = instance.get(Calendar.DAY_OF_WEEK_IN_MONTH);


        StringBuilder builder = new StringBuilder();
        builder.append(year)
                .append("年")
                .append(month)
                .append("月")
                .append(date)
                .append("日")
                .append(" " + hour_24)
                //.append(" " + hour_12 + " " + am_pm_str + " ")
                .append(":" + minute)
                .append(":" + seconde)
                .append(" " + weeks[week-1]);
        System.out.println(builder);
        System.out.println("dayOfMonth:" + dayOfMonth);
        System.out.println("week_of_month:" + week_of_month); //经过了几周
        System.out.println("day_of_year:" + day_of_year);
        System.out.println("day_of_week_in_month:" + day_of_week_in_month); //经过的天数为多少周

    }
}
