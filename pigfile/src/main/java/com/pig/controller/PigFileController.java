package com.pig.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.net.URLEncoder;


@Controller
@RequestMapping(value = "/file")
public class PigFileController {

    static Log log = LogFactory.getLog(PigFileController.class);

    @GetMapping("/down")
    @ResponseBody
    public void downFile(HttpServletRequest request, HttpServletResponse response) throws Exception{
        log.info("begin down file ...");
        String localFileName = "C:\\G\\444\\citys.txt";
        log.info(localFileName);
        File readFile = new File(localFileName);
        FileInputStream fileInputStream = new FileInputStream(readFile);//字节流
        //设置文件下载方式
        response.setHeader("content-disposition","attachment;filename="+ URLEncoder.encode("中文地市.txt","utf-8"));
        // 获取servlet响应输出字节流
        // PrintWriter writer = response.getWriter(); //字符流
        ServletOutputStream outputStream = response.getOutputStream(); //字节流

        //流数据交换，每次交换10k数据大小 （1024k = 1m）
        byte[] bytes = new byte[1024];
        int read;
        while ((read = fileInputStream.read(bytes)) != -1) {
            outputStream.write(bytes,0, read);
        }

        log.info("down file over...");

        if(outputStream != null)
            outputStream.close();

        fileInputStream.close();

    }


}
