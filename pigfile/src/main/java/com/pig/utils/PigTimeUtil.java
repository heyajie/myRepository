package com.pig.utils;


import java.text.ParseException;
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

    /**
     * get week id by the day
     *
     * @param dayTime
     * @return
     */
    public static String getWeekNum(String dayTime){
        String resKey = "0";
        Calendar calendar = Calendar.getInstance();
        //
        Date dateOne;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        try {
            dateOne = sdf.parse(dayTime);
        } catch (ParseException e) {
            e.printStackTrace();
            return resKey;
        }
        calendar.setTime(dateOne);
        // 设置星期一为一周开始的第一天（‌可选，‌根据需要设置）‌
        calendar.setFirstDayOfWeek(Calendar.MONDAY);
        // 获得当前日期属于今年的第几周
        int weekOfYear = calendar.get(Calendar.WEEK_OF_YEAR);
        if(weekOfYear >=0){
            resKey = String.valueOf(weekOfYear);
        }
        return resKey;
    }


    public static void main(String[] args) {

        // //Logger log = Logger.getLogger(PigTimeUtil.class.getName());
        log.info(getToday());

        log.info(getNowWeekNum());
    }

}
