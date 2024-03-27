package com.pig.utils;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

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


    public static void main(String[] args) {

        log.info(TimePigUtil.getTimeNow());
    }
}
