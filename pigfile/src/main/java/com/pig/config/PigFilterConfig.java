package com.pig.config;

import com.pig.filter.PigFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PigFilterConfig {


    @Bean
    public FilterRegistrationBean<PigFilter> registOne(){
        FilterRegistrationBean<PigFilter> bean = new FilterRegistrationBean<>();
        bean.setFilter(new PigFilter());
        bean.addUrlPatterns("/test/*");
        bean.setOrder(1);
        return bean;
    }
}
