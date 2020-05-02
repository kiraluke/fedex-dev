package com.ascending.controller;

import com.ascending.model.User;
import com.ascending.service.JWTService;
import com.ascending.service.UserService;
import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = {"/auth"})
public class AuthController {
    @Autowired
    private UserService userService;
    @Autowired
    private JWTService jwtService;
    Logger logger = LoggerFactory.getLogger(getClass());
    private String errorMsg = "The email or password is not correct.";
//    private String tokenKeyWord = "Authorization";
//    private String tokenType = "Bearer";


    @RequestMapping(value = "/signup", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity singUp(@RequestBody User user) {
//        String token = "";
        Map<String, Object> token;

        try {
            logger.debug(user.toString());
            User u = userService.save(user);
            if (u.getId() == null) return ResponseEntity.status(HttpServletResponse.SC_NON_AUTHORITATIVE_INFORMATION).body(errorMsg);
            logger.debug(u.toString());
            token = jwtService.generateToken(u);
//            token = token.replaceAll("^(.*)$","{\n\"token\"\\:\"$1\"\n}");
        }
        catch (Exception e) {
            String msg = e.getMessage();
            if (msg == null) msg = "BAD REQUEST!";
            logger.error(msg);
            return ResponseEntity.status(HttpServletResponse.SC_BAD_REQUEST).body(msg);
        }

//        return ResponseEntity.status(HttpServletResponse.SC_OK).body(tokenKeyWord + ":" + tokenType + " " + token);
        return ResponseEntity.status(HttpServletResponse.SC_OK).body(token);
    }



    @RequestMapping(value = "/login",method= RequestMethod.POST,produces = "application/json")
    public ResponseEntity<?> userLogin(@RequestBody User user) throws Exception {

//        String token ="";
        Map<String,Object> token;
//        Map<String,String> authentication = new HashMap<>();
        try {
//            String digestPassword = DigestUtils.md5Hex(password.trim());
            logger.debug(user.toString());
            User u = userService.getUserByCredentials(user.getEmail(), user.getPassword());
            token = jwtService.generateToken(u);

            if (u == null){
                //authentication.put("msg", errorMsg);
                return ResponseEntity.status(HttpServletResponse.SC_UNAUTHORIZED).body(errorMsg);
            }
            logger.debug(u.toString());

            //authentication.put("token",token);
//            token = token.replaceAll("^(.*)$","{\n\"token\"\\:\"$1\"\n}");
//            logger.debug("The generated token in Json format is: " + token);

        }catch(Exception e){
            String msg = e.getMessage();
            if(msg==null) msg = "BAD REQUEST!";
            logger.error(msg);
            //authentication.put("msg",msg);
            return ResponseEntity.status(HttpServletResponse.SC_BAD_REQUEST).body(errorMsg);
        }
//        return ResponseEntity.ok().body(tokenKeyWord + ":" + tokenType +" " + token);
//        return ResponseEntity.status(HttpServletResponse.SC_OK).body(token.toString());
        return ResponseEntity.status(HttpServletResponse.SC_OK).body(token);
    }
}
