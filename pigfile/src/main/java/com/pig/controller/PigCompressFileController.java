package com.pig.controller;

import com.pig.utils.PigIOUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPOutputStream;


@Controller
@RequestMapping(value = "/compressFile")
public class PigCompressFileController {

    static Log log = LogFactory.getLog(PigCompressFileController.class);

    @GetMapping("/compress")
    @ResponseBody
    public void downFile(HttpServletRequest request, HttpServletResponse response) {
        log.info("begin down file ...a.csv..a.csv.gz");
        //String localFileName = "C:\\G\\444\\test2.txt";
        log.info(request.getRequestURI());

        response.setCharacterEncoding("utf-8");
        GZIPOutputStream outputStreamWriter = null;
        try {
            response.reset();
            response.setContentType("application/octet-stream");
            response.setHeader("Content-disposition", "attachment; filename="+ URLEncoder.encode("中文name.csv.gz","utf-8"));

            int total = 10*10000;
            try {
                long t = System.currentTimeMillis();
                outputStreamWriter = new GZIPOutputStream(response.getOutputStream());
                buildGZFile("id,名name,fileName", "ID,TESTNAME,FILENAME",
                        total, getDataMap(), outputStreamWriter);
                //
                log.info("load and write excel: " + (System.currentTimeMillis() - t) + " ==" );

                outputStreamWriter.flush();
            } catch (Exception e) {
                e.printStackTrace();
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            PigIOUtil.closeOut(outputStreamWriter);
        }

    }


    public void buildGZFile(String head, String cols, int total,
                            List<Map<String, Object>> list, GZIPOutputStream wb) {
        try {
            wb.write(new byte[]{(byte) 0xEF, (byte) 0xBB, (byte) 0xBF});
            StringBuffer header = new StringBuffer();
            String[] split = cols.split(",");
            wb.write((head + "\r").getBytes());
            long wc = 1;
            if (list != null && list.size() > 0) {
                for (Map<String, Object> map : list) {
                    StringBuffer body = new StringBuffer();
                    for (int i = 0; i < split.length; i++) {
                        String id = split[i];
                        body.append(map.get(id)).append(",");
                    }
                    wb.write((body.toString() + "\r").getBytes());
                    wc++;
                    if (wc % 10000 == 0) {
                        wb.flush();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static List<Map<String, Object>> getDataMap(){
        List<Map<String, Object>> res = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            Map<String, Object> m = new HashMap<>();
            m.put("ID", "ID"+i);
            m.put("AGE", "5"+i);
            m.put("TESTNAME", "test"+i);
            m.put("FILENAME", "file_"+i + ".csv");
            res.add(m);
        }
        return res;
    }
}
