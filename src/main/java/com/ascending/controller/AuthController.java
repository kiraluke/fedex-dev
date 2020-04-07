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

@RestController
@RequestMapping(value = {"/auth"})
public class AuthController {
    @Autowired
    private UserService userService;
    @Autowired
    private JWTService jwtService;
    Logger logger = LoggerFactory.getLogger(getClass());

    @RequestMapping(value = "",method= RequestMethod.POST)
    public ResponseEntity userLogin(@RequestBody User user) throws Exception {
        try {
//            String digestPassword = DigestUtils.md5Hex(password.trim());
            User u = userService.getUserByCredentials(user.getEmail(), user.getPassword());
            if(u==null) return ResponseEntity.status(HttpServletResponse.SC_UNAUTHORIZED).build();
            return ResponseEntity.ok().body(jwtService.generateToken(u));
        }catch(Exception e){
            e.printStackTrace();
            return ResponseEntity.notFound().build();
        }
    }
}
