//package com.ascending.jdbc;
//
//import com.ascending.model.Recipient;
//import org.junit.*;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import java.util.List;
//
//public class RecipientDaoTest {
//    private Logger logger = LoggerFactory.getLogger(getClass());
//    private RecipientDao recipientDao;
//    private Recipient testRecord;
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
//        testRecord = new Recipient();
//        recipientDao = new RecipientDao();
//        testRecord = RecipientDao.save(testRecord);
//    }
//    @After
//    public void tearDown(){
////        logger.info("executing after");
//        System.out.println("executing after");
//        RecipientDao.delete(testRecord.getId());
//    }
//    @Test
//    public void getRecipient(){
//        List<Recipient> recipients = RecipientDao.getRecipients();
//        int expectedNumOfRecip = 5;
//        Assert.assertEquals(expectedNumOfRecip,recipients.size());
//    }
//}
