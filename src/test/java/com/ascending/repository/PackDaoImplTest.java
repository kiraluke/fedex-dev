package com.ascending.repository;

import com.ascending.model.Pack;
import com.ascending.model.Recipient;
import com.ascending.util.ApplicationBootsTrap;
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
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ApplicationBootsTrap.class)
public class PackDaoImplTest {
        private Logger logger = LoggerFactory.getLogger(getClass());
        @Autowired
        private PackDao packDao;
        private Pack pack;

    @Before
    public void setUp(){
         pack = new Pack();
         pack.setTrackingid("2321ssdsd");
         pack.setCategory("fedex pack");
         pack.setDestination("Fairfax");
         packDao.save(pack);
    }
    @After
    public void tearDown(){
        packDao.delete(pack);
    }
    @Test
    public void getPacksTest() {
        List<Pack> packs = packDao.getPacks();
        int expectedNumOfPack = 1;
        Assert.assertEquals(expectedNumOfPack, packs.size());
    }
    @Test
    public void updateTest(){
        pack.setTrackingid("nn19940525");
        packDao.update(pack);
        Assert.assertEquals("nn19940525",pack.getTrackingId());
    }

}
