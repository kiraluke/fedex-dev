package com.ascending.repository;

import com.ascending.model.Pack;
import com.ascending.model.User;
import com.ascending.ApplicationBootsTrap;
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
public class UserDaoImplTest {
    private Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private UserDao userDao;
//    private User user;
//    private Pack pack;
    @Autowired
    private PackDao packDao;
    private User r1;
    private Pack p1;
    private Pack p2;
//    private String recName;

    @Before
    public void setUp(){
//        userDao = new UserDaoImpl();
//        packDao = new PackDaoImpl();
        r1 = new User();
//        recName = "Test";
        r1.setUsername("Test");
        r1.setAddress("777 xxx Rd,falls church,va");
        r1.setEmail("1093599417@qq.com");
        r1 =userDao.save(r1);

        p1 = new Pack();
        p1.setTrackingId("dfdsfsdsd123");
        p1.setDestination("fedex office");
        p1.setUser(r1);
        packDao.save(p1);
        p2 = new Pack();
        p2.setTrackingId("1234tret456");
        p2.setDestination("fedex office");
        p2.setUser(r1);
        packDao.save(p2);
    }
    @After
    public void tearDown(){
        packDao.delete(p1);
        packDao.delete(p2);
        userDao.delete(r1);
    }
    //tearDown
//    {userDao.delete(r)}
    @Test
    public void getUsers(){
        List<User> users = userDao.getUsers();
        int expectNumOfUser = 1;
        assertEquals(expectNumOfUser,users.size());
    }

    @Test
    public void getUserByNameTest(){
//      r1.setName("Nanase");
//      userDao.update(r1);
//      assertEquals("Nanase",r1.getName());
        User testUser = userDao.getUserByName(r1.getUsername());
        assertEquals(testUser.getUsername(), "Test");
    }

    @Test
    public void updateTest(){
//        String userName = "Nishino";
        String address = "Osaka";
        String email = "nishinonnanase@gmail.com";
        r1.setUsername("Nishino");
        r1.setAddress(address);
        r1.setEmail(email);
        userDao.update(r1);
        List<User> users = userDao.getUsers();
        int expectNumOfUser = 1;
        assertEquals(expectNumOfUser,users.size());
    }

    @Test
    public void getUsersAndPacksByTest(){
      List<Pack> result = (List<Pack>) userDao.getUserInfoAndPacksBy("Test");
      Assert.assertEquals(result.size(),2);
      assertEquals(r1.getUsername(), "Test");
//      List<Pack> packList = result.getPacks();
//      assertEquals(packList.size(),2);
    }
}
