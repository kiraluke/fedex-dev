package com.ascending.repository;

import com.ascending.model.Pack;
import com.ascending.model.Routing;
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
public class RoutingDaoImplTest {
    private Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private RoutingDao routingDao;
    private Routing r2;
    @Autowired
    private PackDao packDao;
    private Pack p3;
    private Pack p4;
//    String pirority;
    @Before
    public void setUp(){
       r2 = new Routing();
       r2.setPirority("Pirority Overnight");
       r2.setArea("Annandale");
       routingDao.save(r2);
       p3 = new Pack();
       p3.setTrackingId("sdasdas213213");
       p3.setCategory("fedex large box");
       p3.setDestination("Fedex office");
       packDao.save(p3);
       p4 = new Pack();
       p4.setTrackingId("fasdsads13234");
       p4.setCategory("fedex tube");
       p4.setDestination("fedex recidient");
       packDao.save(p4);
    }
    @After
    public void tearDown(){
        packDao.delete(p3);
        packDao.delete(p4);
        routingDao.delete(r2);
    }
    @Test
    public void getRoutingTest(){
        List<Routing> routings = routingDao.getRoutings();
        int expectNumOfUser = 1;
        assertEquals(expectNumOfUser,routings.size());
    }
    @Test
    public void updateTest(){
        r2.setPirority("express saver");
        routingDao.update(r2);
        assertEquals("express saver",r2.getPirority());
    }
    @Test
    public void getRoutingAndPackTest(){
        List<Pack> result = (List<Pack>) routingDao.getRoutingAndPack("Pirority Overnight");
        assertEquals(r2.getPirority(),"Pirority Overnight");
        assertEquals(result.size(),1);
    }
    @Test
    public void getRoutingByPirorityTest(){
        Routing testRouting = routingDao.getRoutingByPirority(r2.getPirority());
        assertEquals(testRouting.getPirority(),"Pirority Overnight");
    }
}