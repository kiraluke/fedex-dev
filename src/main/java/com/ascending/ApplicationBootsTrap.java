package com.ascending;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
//import com.ascending.service.FileService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(scanBasePackages = {"com.ascending"})
@ServletComponentScan(basePackages = {"com.ascending.filter"})
public class ApplicationBootsTrap extends SpringBootServletInitializer {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationBootsTrap.class, args);
    }


//    @Bean
//    public FileService getFileService() {
//        AmazonS3 s3Client = AmazonS3ClientBuilder.standard().build();
//        FileService fileService = new FileService(s3Client);
//        return fileService;
//    }
}
