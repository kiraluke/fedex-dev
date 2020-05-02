package com.ascending.service;

import com.ascending.ApplicationBootsTrap;
import com.ascending.model.Role;
import com.ascending.model.User;
import com.ascending.repository.RoleDao;
import io.jsonwebtoken.Claims;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = ApplicationBootsTrap.class)
public class JWTServiceTest {


    @Autowired
    private JWTService jwtService;
    @Autowired
    private UserService userService;
    private User user;

    @Before
    public void setUp(){
        user = new User();
        user = userService.getUserByName("Luke");
//        user.setUsername("LukeTest");
//        user.setEmail("lukelu910520@gmail.com");
//        user.setFirstName("Yan");
//        user.setLastName("Lu");
//        user.setPassword("23213232sdas");
//        userService.save(user);
    }
    @After
    public void tearDown(){
//        userService.delete(user.getUsername());
    }

    //TODO
    @Test
    public void getGenerateTokenTest(){
        Map<String, Object> token = new HashMap<>();
        token.put("token",jwtService.generateToken(user));
        assertEquals(token.toString().split("\\.").length,3);
    }

    @Test
    public void decodeJwtTokenTest(){
        Map<String, Object> token;
        token = jwtService.generateToken(user);
        Claims claims = jwtService.decodeJwtToken(token);
        assertEquals(Long.toString(user.getId()),claims.getId());
    }
}
