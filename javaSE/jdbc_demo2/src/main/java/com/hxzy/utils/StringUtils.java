package com.hxzy.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StringUtils {

    private static Logger logger = LoggerFactory.getLogger(StringUtils.class);

    /**
     * 验证字符串或对象是否为null
     * @param obj
     * @return
     */
    public static boolean isEmptyOrNull(Object obj ){
        if (obj == null) return true;
        if (obj instanceof String) {
            String target = (String) obj;
            return "".equals(target);
        }
        return false;
    }

    /**
     * 将字符串转换为java.util.Date
     * @param str  字符串需满足yyyy-MM-dd的格式
     * @return
     */
    public static Date convertStr2Date(String str){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return sdf.parse(str);
        } catch (ParseException e) {
            //e.printStackTrace();
            logger.error(e.getMessage());
            return new Date();
        }
    }

    /**
     * 将日期转换为字符串
     * @param date
     * @return
     */
    public static String convertDate2Str(Date date){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String format = sdf.format(date);
        return format;
    }
}
