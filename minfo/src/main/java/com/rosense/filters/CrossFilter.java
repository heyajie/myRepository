package com.rosense.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter
public class CrossFilter implements Filter {
    @Override
    public void doFilter(ServletRequest sRequest, ServletResponse sResponse, FilterChain filterChain) throws IOException, ServletException {

//        HttpServletResponse response = (HttpServletResponse) sResponse;
//        response.setHeader("Access-Control-Allow-Origin", "*");
//        response.setHeader("Access-Control-Allow-Methods", "*");
//        response.setHeader("Access-Control-Max-Age", "36000");
//        response.setHeader("Access-Control-Allow-Headers", "*");
//        response.setHeader("Access-Control-Allow-Credentials", "true");
        filterChain.doFilter(sRequest, sResponse);
    }
}
