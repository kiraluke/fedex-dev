package com.ascending.controller;

//import com.ascending.service.FileService;

import com.ascending.service.File2Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping(value = {"/files"})
public class FileController {
    private Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private File2Service fileService;
    @RequestMapping(value = "",method = RequestMethod.POST,consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public void uploadFile(@RequestParam("file") MultipartFile mf) {
        logger.info(">>>>>>>>>>"+mf.getName());
        try{
            fileService.uploadFile("nanase7",mf);
        }catch(Exception e){

        }
//        logger.info("test file name: " + file.getOriginalFileName());
//        File temp = new File("/Users/ascending/Downloads/JWT-revised.pdf");
//        try {
//            mf.transferTo(temp);
//            fileService.uploadFile(temp);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }


    }
}
