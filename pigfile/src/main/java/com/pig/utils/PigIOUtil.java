package com.pig.utils;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class PigIOUtil {

    static Log log = LogFactory.getLog(PigIOUtil.class);

    private PigIOUtil(){}

    public static void closeIn(InputStream in){
        if(in != null){
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void closeOut(OutputStream out){
        if(out != null){
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void closeStream(InputStream in, OutputStream out){
        PigIOUtil.closeIn(in);
        PigIOUtil.closeOut(out);
    }

    public static void main(String[] args) {
        PigIOUtil.closeStream(null, null);
        log.info("");
    }
}
