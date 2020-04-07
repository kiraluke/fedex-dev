package com.ascending.controller;

import com.ascending.model.User;
import com.ascending.service.JWTService;
import com.ascending.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = {"/auth"})
public class Authentication {
    @Autowired
    private UserService userService;
    Logger logger = LoggerFactory.getLogger(getClass());
    private String errorMsg = "The email or password is not correct.";
    private String tokenKeyWord = "Authorization";
    private String tokenType = "Bearer";

//    @RequestMapping(value = "", method = RequestMethod.POST,produces = "application/json")
//    public String authentication(@RequestBody User user) {
//        //1.validate username/password
//        //2.generate token
//        String token;
//        token = JWTService.generateToken(user);
//        return token;
//    }
    @RequestMapping(value = "", method = RequestMethod.POST,produces = "application/json")
    public ResponseEntity authentication(@RequestBody User user) {
        String token = "";
        Map<String,String> result = new HashMap<>();
        try{
            logger.debug(user.toString());
            User u = userService.getUserByCredentials(user.getEmail(),user.getPassword());

            if(u == null)return ResponseEntity.status(HttpServletResponse.SC_INTERNAL_SERVER_ERROR).body(errorMsg);
            logger.debug(u.toString());
            token = JWTService.generateToken(u);
        }
        catch(Exception e){
            String msg = e.getMessage();
            if(msg == null)msg = "BAD REQUEST!";
            logger.error(msg);
            return ResponseEntity.status(HttpServletResponse.SC_BAD_REQUEST).body(msg);
        }
        return ResponseEntity.status(HttpServletResponse.SC_OK).body(tokenKeyWord + ":" + tokenType + " " + token);
    }
}
