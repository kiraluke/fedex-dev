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
import java.util.Set;

import static org.junit.Assert.assertEquals;
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ApplicationBootsTrap.class)
public class RecipientDaoImplTest {
    private Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private RecipientDao recipientDao;
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
        r1 =recipientDao.save(r1);

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
        recipientDao.delete(r1);
    }
    //tearDown
//    {recipientDao.delete(r)}
    @Test
    public void getRecipients(){
        List<Recipient> recipients = recipientDao.getRecipients();
        int expectNumOfRecipient = 1;
        assertEquals(expectNumOfRecipient,recipients.size());
    }
//    @Test
//    public void getRecipientByNameTest(){
//      recipient.setName("Nanase");
//      recipientDao.save(recipient);
//      assertEquals("Nanase",recipient.getName());
//    }
    @Test
    public void updateTest(){
        String recipientName = "Nishino";
        String address = "Osaka";
        String email = "nishinonnanase@gmail.com";
        recipient.setName(recipientName);
        recipient.setAddress(address);
        recipient.setEmail(email);
        recipientDao.update(recipient);
        List<Recipient> recipients = recipientDao.getRecipients();
        int expectNumOfRecipient = 1;
        assertEquals(expectNumOfRecipient,recipients.size());
    }
    @Test
    public void getRecipientsAndPacksByTest(){
      Recipient result = (Recipient) recipientDao.getRecipientsAndPacksBy(recName);
      Assert.assertEquals(result.getName(),recName);
      Set<Pack> packSet = result.getPack();
      assertEquals(packSet.size(),2);
    }
}
