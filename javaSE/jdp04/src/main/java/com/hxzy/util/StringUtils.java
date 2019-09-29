package com.hxzy.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StringUtils {

    public static Date convertStr2Date(String str){
        SimpleDateFormat sdf = getFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date parse = sdf.parse(str);
            return parse;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String convertDate2Str(Date date){
        SimpleDateFormat sdf = getFormat("yyyy-MM-dd HH:mm:ss");
        String format = sdf.format(date);
        return format;
    }
    private static SimpleDateFormat getFormat(String pattern){
        return new SimpleDateFormat(pattern);
    }

    public static boolean strNotEmpty(String str){
        return str != null && !str.equals("");
    }
}
