package com.ascending.jdbc;

import com.ascending.model.Pack;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class PackDaoTest {
//    private Logger logger = Logger
    private PackDao packDao;
    private Pack testRecord;

    @Before
    public void setUp(){
        testRecord = new Pack();
        packDao = new PackDao();
        packDao.save(testRecord);
    }
    @After
    public void tearDown(){
        packDao.delete(testRecord.getTrackingid());
    }

    @Test
    public void getPacksTest(){
        System.out.println("Test method 1");
        List<Pack> packs = packDao.getPacks();
        int expectedNumOfPack = 5;

        Assert.assertEquals(expectedNumOfPack,packs.size());
    }
}
