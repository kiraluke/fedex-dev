//package com.ascending.service;
//
//import com.amazonaws.services.s3.AmazonS3;
//import com.amazonaws.services.s3.model.PutObjectRequest;
//import com.ascending.ApplicationBootsTrap;
//import org.junit.After;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.Mockito;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.context.annotation.Profile;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import javax.swing.text.Document;
//import java.io.File;
//import java.net.MalformedURLException;
//import java.net.URL;
//
//
//import static org.mockito.ArgumentMatchers.anyString;
//import static org.mockito.Mockito.*;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = ApplicationBootsTrap.class)
//public class File2ServiceTest {
//    @Autowired
//    private File2Service file2Service;
//    @Autowired
//    private AmazonS3 s3Client;
//
//    @After
//    public void tearDown(){
//        //null point exception
//        //return the payment;
//    }
//
//    @Test
//    public void uploadFileTest(){
////        AmazonS3 s3Client = mock(AmazonS3.class);
////        s3Client.putObject("xxx","xxx","String of Object");
////        verify(s3Client,times(1)).putObject(anyString(),anyString(),anyString());
////        File testFile = new File("/Users/ascending/Documents/WechatIMG4.jpeg");
////        file2Service.uploadFile(testFile);
//        File testFile = Mockito.mock(File.class);
//        file2Service.uploadFile(testFile);
//        verify(s3Client,times(1)).putObject(any(PutObjectRequest.class));
//        file2Service.uploadFile(null);
//        verify(s3Client,times(0)).putObject(any(PutObjectRequest.class));
//    }
//
//    @Test
//    public void getUrlTest() throws MalformedURLException {
////        when(s3Client.getUrl(anyString(),anyString())).thenReturn(mock(URL.class));
////        file2Service.getUrl(null);
////        verify(s3Client,times(0)).getUrl(anyString(),anyString());
//
//        when(s3Client.getUrl(anyString(),anyString())).thenReturn(new URL("http","ascendingdc.com",123,"xxx"));
//        file2Service.getUrl("yanluke");
//        verify(s3Client,times(1)).getUrl(anyString(),anyString());
//    }
//}
