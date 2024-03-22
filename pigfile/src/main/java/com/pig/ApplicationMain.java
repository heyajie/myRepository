package com.pig;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by admin on 2024/3/13.
 */

@SpringBootApplication
public class ApplicationMain {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationMain.class, args);
		
        System.out.println(":: Spring Boot ::  (v2.1.4.RELEASE)");
    }
}
