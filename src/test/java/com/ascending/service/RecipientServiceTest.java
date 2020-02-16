package com.ascending.service;

import com.ascending.model.Pack;
import com.ascending.model.Recipient;
import com.ascending.repository.PackDao;
import com.ascending.repository.RecipientDao;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class RecipientServiceTest {
    private Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private RecipientService recipientService;
    private Recipient recipient;
    private Pack pack;
    @Autowired
    private PackDao packDao;
    private Recipient r1;
    private Pack p1;
    private Pack p2;
    private String recName = "Luke";

    @Before
    public void setUp(){
//        recipientDao = new RecipientDaoImpl();
//        packDao = new PackDaoImpl();
        r1 = new Recipient();
        r1.setName(recName);
        r1.setAddress("777 xxx Rd,falls church,va");
        r1.setEmail("1093599417@qq.com");
        r1 =recipientService.save(r1);

        p1 = new Pack();
        p1.setTrackingid("dfdsfsdsd123");
        p1.setDestination("fedex office");
        p1.setRecipient(r1);
        packDao.save(p1);
        p2 = new Pack();
        p2.setTrackingid("1234tret456");
        p2.setDestination("fedex office");
        p2.setRecipient(r1);
        packDao.save(p2);
    }
    @After
    public void tearDown(){
        packDao.delete(p1);
        packDao.delete(p2);
        recipientService.delete(r1);
    }
    @Test
    public void getRecipients(){
        List<Recipient> recipients = recipientService.getRecipients();
        int expectNumOfRecipient = 1;
        assertEquals(expectNumOfRecipient,recipients.size());
    }
}
