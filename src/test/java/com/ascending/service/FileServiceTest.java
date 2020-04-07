package com.ascending.service;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.PutObjectResult;
import com.ascending.ApplicationBootsTrap;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatcher;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;

import static org.junit.Assert.assertNotNull;
import static org.mockito.AdditionalMatchers.eq;
import static org.mockito.ArgumentMatchers.anyString;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ApplicationBootsTrap.class)
public class FileServiceTest {
    @Autowired
    private FileService fileService;
    @Before
    public void setUp(){

    }
//    @Test
//public void FileServiceTest(){
////    AmazonS3 s3Fake = mock(AmazonS3.class);
////    fileService.setBucket("JWT-revised.pdf");
//    File file = new File("/Users/ascending/Downloads/JWT-revised.pdf");
//    fileService.uploadObject(file);
//         Mockito.verify(fileService.getS3Client(), times(1))
//                .putObject(eq(fileService.getBucketName()), eq(file.getName()),anyString());
//        assertNotNull(fileService.getObjectUrl(file.getName()));
//}


}
//    eq(fileService.getBucketName(),eq(file.getName()),anyString()