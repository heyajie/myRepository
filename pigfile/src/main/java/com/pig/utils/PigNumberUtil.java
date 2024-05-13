package com.pig.utils;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.math.BigDecimal;
import java.util.Random;

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
        log.info("getPhoneSms()= " + getPhoneSms());
    }

    public static String getPhoneSms(){
        Random random = new Random();
        int code = random.nextInt(999999) + 100000;
        if(code >= 100*10000){
            code = code/10;
        }
        if(code < 100000){
            code = code*10;
        }
        return String.valueOf(code);
    }
}
