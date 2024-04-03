package com.pig.utils;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class TimePigUtil {

    static Log log = LogFactory.getLog(TimePigUtil.class);

    private TimePigUtil(){}

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");

    public static String getTimeNow() {
        return dateFormat.format(new Date());
    }

    /**
     * get pre day
     * yyyyMMdd
     * 
     * @param time
     * @param delay
     * @return
     */
    public static String getPreDay(String time, int delay) {
        time = time.replaceAll(" ", "");
        time = time.replaceAll("-", "");
        Calendar cal = Calendar.getInstance();
        Date date = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        try {
            date = sdf.parse(time);
        } catch (ParseException e) {e.printStackTrace();}
        cal.setTime(date);
        cal.add(Calendar.DAY_OF_MONTH, delay);
        return sdf.format(cal.getTime());
    }


    public static String getStartDayOneWeek(String dTime, int num) {
        if (dTime == null)
            return "";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        dTime = dTime.replaceAll("-","");
        dTime = dTime.replaceAll(" ","");
        Date parseDate = null;
        try {
            parseDate = sdf.parse(dTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeZone(TimeZone.getTimeZone("GMT+8"));
        calendar.setTime(parseDate);
        //start of the week
        if (calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
            calendar.add(Calendar.DAY_OF_YEAR,-1);
        }
        calendar.add(Calendar.DAY_OF_WEEK, -(calendar.get(Calendar.DAY_OF_WEEK) - num));
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return sdf.format(calendar.getTime());
    }

    public static void main(String[] args) {

        log.info(TimePigUtil.getTimeNow());
    }
}
