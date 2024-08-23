package com.pig.utils;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Logger;

public class PigTimeUtil {

    public static Logger log = Logger.getLogger(PigTimeUtil.class.getName());

    public static String getToday(){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        return dateFormat.format(new Date());
    }

    public static String getNowWeekNum(){
        Calendar calendar = Calendar.getInstance();
        // 设置星期一为一周开始的第一天（‌可选，‌根据需要设置）‌
        calendar.setFirstDayOfWeek(Calendar.MONDAY);
        // 获得当前日期属于今年的第几周
        int weekOfYear = calendar.get(Calendar.WEEK_OF_YEAR);
        return ""+weekOfYear;
    }


    public static void main(String[] args) {

        // //Logger log = Logger.getLogger(PigTimeUtil.class.getName());
        log.info(getToday());

        log.info(getNowWeekNum());
    }

}
