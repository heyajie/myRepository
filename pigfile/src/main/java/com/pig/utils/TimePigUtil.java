package com.pig.utils;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.time.DayOfWeek;
import java.time.LocalDate;

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
        time = time.replaceAll("[ ]", "");
        time = time.replaceAll("[-]", "");
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
        dTime = dTime.replaceAll("[-]","");
        dTime = dTime.replaceAll("[ ]","");
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


    public static String getMondayDate() {
        LocalDate currentDate = LocalDate.now();
        DayOfWeek currentDayOfWeek = currentDate.getDayOfWeek();
//        System.out.println(DayOfWeek.MONDAY.getValue()); // monday
//        System.out.println(DayOfWeek.TUESDAY.getValue()); // tuesday
//        System.out.println(DayOfWeek.WEDNESDAY.getValue()); // wednesday
//        System.out.println(DayOfWeek.THURSDAY.getValue()); // thursday
//        System.out.println(DayOfWeek.FRIDAY.getValue()); // friday
//        System.out.println(DayOfWeek.SATURDAY.getValue()); // saturday
//        System.out.println(DayOfWeek.SUNDAY.getValue()); // sunday
        int daysToSubtract = currentDayOfWeek.getValue() - DayOfWeek.MONDAY.getValue();
        if (daysToSubtract < 0) {
            daysToSubtract += 7; // Add 7 to handle negative result
        }
        daysToSubtract += 7; // last week
        daysToSubtract += 7; // two weeks ago
        LocalDate mondayDate = currentDate.minusDays(daysToSubtract);
        return mondayDate.toString().replace("-", ""); // Format: yyyyMMdd
    }

    public static String getTimeArr(String day, boolean isNum){
        StringBuilder buff = new StringBuilder("");
        if(isNum){
            buff.append(day);
        }else {
            buff.append("'").append(day).append("'");
        }
        for (int i = 0; i < 6; i++) {
            String tmpDay = getPreDay(day, -i-1);
            if(isNum){
                buff.append(",").append(tmpDay);
            }else {
                buff.append(",'").append(tmpDay).append("'");
            }
        }
        return buff.toString();
    }

    public static void main(String[] args) {

        //log.info(TimePigUtil.getTimeNow());

        log.info(getMondayDate());
        //
        log.info(getTimeArr("20240606", false));
    }
}
