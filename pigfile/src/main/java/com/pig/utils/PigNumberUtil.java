package com.pig.utils;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.math.BigDecimal;
import java.util.Random;

public class PigNumberUtil {

    static Log log = LogFactory.getLog(PigNumberUtil.class);

    private PigNumberUtil(){}

    /**
     * change to Double,精度问题转换,
     * @param f
     * @return
     */
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


    public static String trimNull(Object o,String def){
        if(o == null){
            return def;
        }
        String str = String.valueOf(o);
        if("null".equalsIgnoreCase(str) || str.length()==0){
            return def;
        }
        return str;
    }

    /**
     *  four decimal,
     *
     * @param vfz
     * @param vfm
     * @return
     */
    public static String getSmall(Object vfz, Object vfm, int digit){
        String fz = String.valueOf(vfz);
        String fm = String.valueOf(vfm);
        if(fm==null || "".equals(fm) || "0".equals(fm) || "null".equalsIgnoreCase(fm) ||
                fz==null || "".equals(fz) || "0".equals(fz) || "null".equalsIgnoreCase(fz)){
            return "0.00";
        }else {
            BigDecimal ffz = new BigDecimal(fz);
            BigDecimal ffm = new BigDecimal(fm);
            BigDecimal divide = ffz.divide(ffm, digit, BigDecimal.ROUND_HALF_UP);
            return divide.toString();
        }
    }
    public static String getSmall(Object vfz, Object vfm){
        return getSmall(vfz, vfm, 4);
    }
}
