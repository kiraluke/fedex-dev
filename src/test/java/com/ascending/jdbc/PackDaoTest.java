//package com.ascending.jdbc;
//
//import com.ascending.model.Pack;
//import org.junit.After;
//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.Test;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import java.util.List;
//
//public class PackDaoTest {
//    private Logger logger = LoggerFactory.getLogger(getClass());
//    private PackDao packDao;
//    private Pack testRecord;
//    private String expectedDestination = "expectedDestination";
//
//    @Before
//    public void setUp(){
//        logger.debug("executing before");
//        testRecord = new Pack();
//        packDao = new PackDao();
//        packDao.save(testRecord);
////        testRecord = packDao.getPackByDestination(expectedDestination);
//    }
//    @After
//    public void tearDown(){
//        logger.info("executing after");
//        packDao.delete(testRecord.getTrackingid());
//
//    }
//
//    @Test
//    public void getPacksTest(){
//        System.out.println("Test method 1");
//        List<Pack> packs = packDao.getPacks();
//        int expectedNumOfPack = 5;
//        Assert.assertEquals(expectedNumOfPack,packs.size());
//    }
//    @Test
//    public void getPackByDestinationTest(){
//        System.out.println("Test Method 2");
//        Pack p = packDao.getPackByDestination(expectedDestination);
//        Assert.assertEquals(expectedDestination,p.getDestination());
//    }
//    @Test
//    public void deleteTest(){
//        System.out.println("Test method 3");
//        packDao.delete(testRecord.getTrackingid());
//        int expectedNumOfPack = 3;
//        List<Pack> packs = packDao.getPacks();
//        Assert.assertEquals(expectedNumOfPack,packs.size());
//    }
//}
