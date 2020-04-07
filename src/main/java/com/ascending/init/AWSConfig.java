//package com.ascending.init;
//
//import com.amazonaws.services.s3.AmazonS3;
//import com.amazonaws.services.s3.AmazonS3ClientBuilder;
//import com.ascending.service.FileService;
//import org.hibernate.id.Configurable;
//import org.springframework.beans.factory.config.ConfigurableBeanFactory;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Profile;
//import org.springframework.context.annotation.Scope;
//
//@Configuration
//@Profile("dev")
//public class AWSConfig {
//    @Bean
//    public FileService getFileService() {
//        AmazonS3 s3Client = AmazonS3ClientBuilder.standard().build();
//        FileService fileService = new FileService(s3Client);
//        return fileService;
//    }
//
////    @Bean
////    public FileService getFileService(){
////        AmazonS3 s3Client = AmazonS3ClientBuilder.standard().build();
////        FileService fileService = new FileService(s3Client);
////        fileService.setBucketName("JWT-revised.pdf");
////        return fileService;
////    }
//
////    @Bean
////    @Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
////    public AmazonS3 getAmazonS3(){
////
////    }
//}
