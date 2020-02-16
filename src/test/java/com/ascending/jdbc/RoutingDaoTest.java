//package com.ascending.jdbc;
//
//import com.ascending.model.Recipient;
//import com.ascending.model.Routing;
//import org.junit.*;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import java.util.List;
//
//public class RoutingDaoTest {
//    private Logger logger = LoggerFactory.getLogger(getClass());
//    private RoutingDao recipientDao;
//    private Routing testRecord;
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
//        testRecord = new Routing();
//        recipientDao = new RoutingDao();
//        testRecord = RoutingDao.save(testRecord);
//    }
//    @After
//    public void tearDown(){
////        logger.info("executing after");
//        System.out.println("executing after");
//        RecipientDao.delete(testRecord.getId());
//    }
//    @Test
//    public void getRouting(){
//        List<Routing> routings = RoutingDao.getRouting();
//        int expectedNumOfRout = 5;
//        Assert.assertEquals(expectedNumOfRout,routings.size());
//    }
////    @Test
////    public void getPackByTrackingid(){
////        int trackingid = 7777;
////        Recipient routing = (Routing) recipientDao.getRoutingByTrackingid(trackingid);
////        Assert.assertEquals(java.util.Optional.of(trackingid), routing.getTrackingid());
////        logger.debug(routing.toString());
////    }
//}
