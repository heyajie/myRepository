package com.pig.utils;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimePigUtil {

    static Log log = LogFactory.getLog(TimePigUtil.class);

    private TimePigUtil(){}

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");

    public static String getTimeNow() {
        return dateFormat.format(new Date());
    }


    public static void main(String[] args) {

        log.info(TimePigUtil.getTimeNow());
    }
}
