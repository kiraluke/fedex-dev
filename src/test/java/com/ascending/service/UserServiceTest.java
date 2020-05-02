package com.ascending.service;

import com.ascending.ApplicationBootsTrap;
import com.ascending.model.Pack;
import com.ascending.model.User;
import com.ascending.repository.PackDao;
import com.ascending.repository.UserDao;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ApplicationBootsTrap.class)
public class UserServiceTest {
    private Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private UserDao userService;
//    private User user;
//    private Pack pack;
    @Autowired
    private PackDao packService;
    private User r1;
    private Pack p1;
    private Pack p2;

    @Before
    public void setUp(){
//        userDao = new UserDaoImpl();
//        packDao = new PackDaoImpl();
        r1 = new User();
        r1.setUsername("Test");
        r1.setAddress("777 xxx Rd,falls church,va");
        r1.setEmail("1093599417@qq.com");
        r1.setPassword("password");
        userService.save(r1);

        p1 = new Pack();
        p1.setTrackingId("dfdsfsdsd123");
        p1.setDestination("fedex office");
        p1.setUser(r1);
        packService.save(p1);
        p2 = new Pack();
        p2.setTrackingId("1234tret456");
        p2.setDestination("fedex office");
        p2.setUser(r1);
        packService.save(p2);
    }
    @After
    public void tearDown(){
        packService.delete(p1);
        packService.delete(p2);
        userService.delete(r1);
    }
    @Test
    public void getUsers(){
        List<User> users = userService.getUsers();
        int expectNumOfUser = 1;
        assertEquals(expectNumOfUser,users.size());
    }
    @Test
    public void getUserByNameTest(){
        r1.setUsername("Nanase");
        userService.update(r1);
        User testUser = userService.getUserByName(r1.getUsername());
        assertEquals(testUser.getUsername(), "Nanase");
    }
    @Test
    public void updateTest(){
        String address = "Osaka";
        String email = "nishinonnanase@gmail.com";
        r1.setUsername("Nishino");
        r1.setAddress(address);
        r1.setEmail(email);
        userService.update(r1);
        //List<User> users = userService.getUsers();
        //int expectNumOfUser = 1;
        //assertEquals(expectNumOfUser,users.size());
        assertEquals(r1.getUsername(), "Nishino");
    }
    @Test
    public void getUsersAndPacksByTest() {
        List<Pack> result = (List<Pack>) userService.getUserInfoAndPacksBy("Test");
        Assert.assertEquals(result.size(), 2);
        assertEquals(r1.getUsername(), "Test");
    }
    @Test
    public void getUserByIdTest(){
        User testUser = userService.getUserById(r1.getId());
        assertEquals(testUser.getId(),r1.getId());
    }

    @Test
    public void getUserByCredentialTest() throws Exception {
        User testUser = userService.getUserByCredentials(r1.getEmail(),r1.getPassword());
        assertEquals(testUser.getEmail(),"1093599417@qq.com");
        assertEquals(testUser.getPassword(),"password");
    }
}
