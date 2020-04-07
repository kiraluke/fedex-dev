package com.ascending.service;

import com.ascending.ApplicationBootsTrap;
import com.ascending.model.Pack;
import com.ascending.repository.PackDao;
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
public class PackServiceTest {
    private Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private PackDao packService;
    private Pack p5;
    @Before
    public void setUp(){
        p5 = new Pack();
        p5.setTrackingId("2321ssdsd");
        p5.setCategory("fedex pack");
        p5.setDestination("Fairfax");
        packService.save(p5);
    }
    @After
    public void tearDown(){
        packService.delete(p5);
    }
    @Test
    public void getPacksTest() {
        List<Pack> packs = packService.getPacks();
        int expectedNumOfPack = 1;
        Assert.assertEquals(expectedNumOfPack, packs.size());
    }
    @Test
    public void updateTest(){
        String trackId = "nn19940525";
        p5.setTrackingId(trackId);
        p5.setCategory("fedex large box");
        p5.setDestination("Chantilly");
        packService.update(p5);
        Assert.assertEquals(trackId, p5.getTrackingId());
    }
}
