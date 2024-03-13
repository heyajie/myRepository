package com.rosense.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Random;

/**
 * Created by admin on 2021/1/13.
 */
@Controller
public class MetricsController {

    @GetMapping("/metrics")
    public void getName(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String str = "";
        str = "zzkl_minfo{dev=\"test\"} 450" +"\n";

        Random random = new Random();
        for (int i = 0; i < 5; i++) {
            str += "zzkp_count" + i + "{dev=\"tet\",}"  + " " + random.nextInt(1000) + "\n";

        }

//        for (int i = 0; i < 5; i++) {
//            str += "zzhw_count" + i + "{nodename=\"server2\",node=\"171.2.2.2\"}" + " " + random.nextInt(1000) + "\n";
//        }

        response.getOutputStream().write(str.getBytes());
        response.getOutputStream().flush();
        response.getOutputStream().close();
    }
}
