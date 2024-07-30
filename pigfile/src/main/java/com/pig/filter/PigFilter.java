package com.pig.filter;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class PigFilter implements Filter {

    static Log log = LogFactory.getLog(PigFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("init.. PigFilter..");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpResponse = (HttpServletResponse) servletResponse;
        //
        String url = String.valueOf(httpRequest.getRequestURL());
        log.info(url);

        if(url.contains("two22")){
            httpResponse.setCharacterEncoding("UTF-8");
            httpResponse.setContentType("application/json; charset=utf-8");
            Map<String, String> m = new HashMap<>();
            m.put("status", "404");
            m.put("code", "");
            m.put("msg", "");
            m.put("data", null);
            httpResponse.getWriter().append(m.toString());
        }else {
            filterChain.doFilter(servletRequest, servletResponse);
        }

    }

    @Override
    public void destroy() {
        System.out.println("PigFilter.. destroy().....");
    }
}
