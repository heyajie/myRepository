package com.pig.config;



//import org.aspectj.lang.JoinPoint;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Before;
//import org.aspectj.lang.annotation.Pointcut;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Component;
//import org.springframework.web.context.request.RequestContextHolder;
//import org.springframework.web.context.request.ServletRequestAttributes;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//@Aspect
//@Component
//public class UserAspect {
////    @Value("${defPara.userToken}")
////    public String userToken;
//
//
//    @Pointcut("execution(public * com.pig.controller.PigFileController.*(..))")
//    public void userPoint() {
//    }
//
//    @Before(value = "userPoint()")
//    public void beforeUser(JoinPoint joinPoint) throws Throwable{
//        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
//                .getRequest();
//        HttpServletResponse response = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
//                .getResponse();
//        String uri = request.getRequestURI();
//        String uToken = request.getParameter("uToken");
//        if(uToken.equals("abc123456")){
//
//        }else {
//            System.out.println("Aspect token err...");
//            return;
//            //throw new RuntimeException("token is error...");
//        }
//    }
//}
