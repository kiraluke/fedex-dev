package com.ascending.service;

import com.ascending.ApplicationBootsTrap;
import com.ascending.model.User;
import io.jsonwebtoken.Claims;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

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
        User user = new User();
        user.setUsername("Luke");
        user.setEmail("lukelu910520@gmail.com");
        user.setFirstName("Yan");
        user.setLastName("Lu");
        user.setPassword("23213232sdas");
        userService.save(user);
    }
    @After
    public void tearDown(){
        userService.delete(user.getUsername());
    }
    @Test
    public void getGenerateTokenTest(){
        String token = jwtService.generateToken(user);
        assertEquals(token.split("\\.").length,3);
    }

    @Test
    public void decodeJwtTokenTest(){
        String token = jwtService.generateToken(user);
        Claims claims = jwtService.decodeJwtToken(token);
        assertEquals(claims.getId(),user.getId().toString());
    }
}
