package com.ascending.service;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.net.URL;

//@Service
public class FileService {
    private String bucketName = "nanase7";

    private AmazonS3 s3Client;
    public FileService(AmazonS3 s3Client) {
        this.s3Client = s3Client;
    }

    public void uploadObject(File f) throws IllegalArgumentException{
        if(f!=null) {
            s3Client.putObject(bucketName, f.getName(), f);
        }else{
            throw new IllegalArgumentException("File dosen't exist");
        }
    }
    public String getObjectUrl(String key){
        URL url = s3Client.getUrl(bucketName,key);
        if(url==null){
            return null;}
        else{
            return url.toString();
        }
    }
    public void createFolder(){

    }
    public void setBucketName(String bucket){
        this.bucketName = bucketName;
    }

    public String getBucketName() {
        return bucketName;
    }

    public AmazonS3 getS3Client() {
        return s3Client;
    }
}
