package com.pig.utils;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Logger;

public class PigTimeUtil {

    public static Logger log = Logger.getLogger(PigTimeUtil.class.getName());

    public static String getToday(){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        return dateFormat.format(new Date());
    }



    public static void main(String[] args) {

        // //Logger log = Logger.getLogger(PigTimeUtil.class.getName());
        log.info(getToday());
    }

}
