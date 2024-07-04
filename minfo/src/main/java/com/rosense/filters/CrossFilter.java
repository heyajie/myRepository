package com.rosense.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter
public class CrossFilter implements Filter {
    @Override
    public void doFilter(ServletRequest sRequest, ServletResponse sResponse, FilterChain filterChain)
            throws IOException, ServletException {

//        HttpServletResponse response = (HttpServletResponse) sResponse;
//        response.setHeader("Access-Control-Allow-Origin", "*");
//        response.setHeader("Access-Control-Allow-Methods", "*");
//        response.setHeader("Access-Control-Max-Age", "36000");
//        response.setHeader("Access-Control-Allow-Headers", "*");
//        response.setHeader("Access-Control-Allow-Credentials", "true");
        filterChain.doFilter(sRequest, sResponse);
    }

/*
 * 在Spring构架的程序中，如果监听器、过滤器、拦截器和AOP都存在，
 * 它们的执行顺序为：监听器 => 过滤器 => 拦截器 => AOP。
 * 这表明，在SpringBoot应用中，过滤器和拦截器的执行顺序也遵循这一规则，
 * 但具体到过滤器和拦截器之间，
 * 它们的执行顺序仍然受到注册顺序的影响
 */
}
