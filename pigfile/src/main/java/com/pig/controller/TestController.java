package com.pig.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "/test")
public class TestController {


    @GetMapping("/one")
    @ResponseBody
    private Map<String, Object> one(HttpServletRequest request, HttpServletResponse response){

        Map<String, Object> res = new HashMap<>();
        res.put("status", 200);
        res.put("success", "ok");
        res.put("data", new ArrayList<>());
        return res;
    }


    @GetMapping("/two")
    @ResponseBody
    private Map<String, Object> two(HttpServletRequest request, HttpServletResponse response){

        Map<String, Object> res = new HashMap<>();
        res.put("status", 200);
        res.put("success", "ok");
        res.put("data", "three.js");
        return res;
    }
}
