package com.ascending.service;


import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ObjectMetadata;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.URL;
import java.util.UUID;

@Service
public class File2Service {
    Logger logger = LoggerFactory.getLogger(getClass());
    private String defultRegion = "us-east-1";
    private String bucketName = "nanase7";
    @Autowired
    private AmazonS3 s3Client;
    @Autowired
    private AmazonS3 amazonS3;

    public void uploadFile(String bucketName, MultipartFile file) throws IOException {
//        AmazonS3 s3Client;
//                = AmazonS3ClientBuilder.standard()
//                .withRegion(defultRegion)
//                .build();

        // Upload a text string as a new object.
//        s3Client.putObject("nanase7", "WechatIMG4.jpeg", "Uploaded String Object");
//        if(file!=null) {
//            PutObjectRequest request = new PutObjectRequest(bucketName, file.getName(), (File) file);
//            s3Client.putObject(request);
//        }else{
//            logger.error("Can't upload null file.");
//        }
        try {
            String uuid = UUID.randomUUID().toString();
            String originalFilename = file.getOriginalFilename();
//            String newFileName = Files.getNameWithoutExtension(originalFilename) + uuid + Files.getFileExtension(originalFilename);
            ObjectMetadata objectMetadata = new ObjectMetadata();
            objectMetadata.setContentType(file.getContentType());
            objectMetadata.setContentLength(file.getSize());
            amazonS3.putObject(bucketName, file.getOriginalFilename(), file.getInputStream(), null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public String getUrl(String s3Key){
        //return s3Client.getUrl(bucketName,s3Key).toExternalForm();
        try {
            URL url = s3Client.getUrl(bucketName, s3Key);
            return url == null ? null : url.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
