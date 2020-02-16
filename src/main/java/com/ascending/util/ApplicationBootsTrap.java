package com.ascending.util;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.ascending"})
public class ApplicationBootsTrap {
    public static void main(String[] args){
        SpringApplication.run(ApplicationBootsTrap.class,args);
    }
}
