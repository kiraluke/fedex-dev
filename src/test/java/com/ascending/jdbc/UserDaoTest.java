//package com.ascending.jdbc;
//
//import com.ascending.model.User;
//import org.junit.*;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import java.util.List;
//
//public class UserDaoTest {
//    private Logger logger = LoggerFactory.getLogger(getClass());
//    private UserDao userDao;
//    private User testRecord;
//
//    @BeforeClass
//    public static void setUpClass(){
//        System.out.println("executing beforeClass");
//    }
//
//    @Before
//    public void setUp(){
////        logger.debug("executing before");
//        System.out.println("executing before");
//        testRecord = new User();
//        userDao = new UserDao();
//        testRecord = UserDao.save(testRecord);
//    }
//    @After
//    public void tearDown(){
////        logger.info("executing after");
//        System.out.println("executing after");
//        UserDao.delete(testRecord.getId());
//    }
//    @Test
//    public void getUser(){
//        List<User> users = UserDao.getUsers();
//        int expectedNumOfRecip = 5;
//        Assert.assertEquals(expectedNumOfRecip,users.size());
//    }
//}