package com.rosense.controller;

import com.rosense.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 *
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    IUserService userService;

    @GetMapping("/getSome")
    @ResponseBody
    public Map<String, Object> getSome(HttpServletRequest request, HttpServletResponse response){
        System.out.println("getSome...  start");
        List<Map<String, Object>> someUser = userService.getSomeUser();
        System.out.println("getSome...  end...");
        Map<String, Object> userMap = new HashMap<>();
        userMap.put("code","200");
        userMap.put("data", someUser);
        return userMap;
    }


    @GetMapping("/one")
    @ResponseBody
    public Object getName(HttpServletRequest request, HttpServletResponse response) throws IOException {

        System.out.println(request.getRequestURL().toString());

        Enumeration<String> names = request.getHeaderNames();
        while (names.hasMoreElements()){
            String v = names.nextElement();
            System.out.println(v + "<==>" + request.getHeader(v));
        }
        System.out.println("=========================================");
        Enumeration<String> param = request.getParameterNames();
        while (param.hasMoreElements()){
            String key = param.nextElement();
            System.out.println(key + "<==>" + request.getParameter(key));
        }


        Map<String, Object> userMap = new HashMap<>();
        userMap.put("name","admin");
        userMap.put("role","one");
        userMap.put("email","123456@gmail.com");
        Map<String, Object> resMap = new HashMap<>();
        resMap.put("code", "200");
        resMap.put("msg", "ok");
        resMap.put("data", userMap);
        return resMap;
    }

    @GetMapping("/getUserByRole")
    @ResponseBody
    public Map<String, Object> getUserByRole(HttpServletRequest request, HttpServletResponse response,
                                             String paramRole){
        System.out.println("getUserByRole...  start");
        List<Map<String, Object>> someUserRole = userService.getUserByRole(paramRole);
        System.out.println("getUserByRole...  end...");
        Map<String, Object> userMap = new HashMap<>();
        userMap.put("code","200");
        if(!checkOneRole(paramRole)){
            userMap.put("data", new ArrayList<>());
            userMap.put("msg", "params err...");
            return userMap;
        }
        userMap.put("data", someUserRole);
        return userMap;
    }

    private boolean checkOneRole(String role){
        if(role ==null){
            return false;
        }
        if(role.length() >8){
            return false;
        }
        return true;
    }
}
