package com.pig.utils;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.math.BigDecimal;

public class PigNumberUtil {

    static Log log = LogFactory.getLog(PigNumberUtil.class);

    private PigNumberUtil(){}

    public static Double toDouble(Float f){
        if(f == null){
            return 0d;
        }
        BigDecimal b = new BigDecimal(String.valueOf(f));
        return b.doubleValue();
    }

    public static void main(String[] args) {

        Double aDouble = PigNumberUtil.toDouble(3.1452634f);
        log.info("aDouble= " + aDouble);
    }
}
