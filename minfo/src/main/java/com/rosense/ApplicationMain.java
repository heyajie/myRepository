package com.rosense;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by admin on 2021/1/11.
 */
@MapperScan("com.rosense.dao.app")
@SpringBootApplication
public class ApplicationMain {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationMain.class, args);
        System.out.println(":: Spring Boot ::  (v2.1.4.RELEASE)");
    }
}
