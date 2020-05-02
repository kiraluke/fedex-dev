package com.ascending.service;

import com.amazonaws.services.sqs.AmazonSQS;
import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;

public class MessegeServiceMockAWSTest {
    @Autowired
    private AmazonSQS amazonSQS;

    @Before
    public void setUp(){
//        GetQueueUrlResult urlResult = Mockito.mock(GetQueueUrlResult.class);
//        when(urlResult.getQueueUrl()).thenReturn(fakeQueueUrl);
//        when(amazonSQS.getQueueUrl(anyString())),thenReturn();
    }
}
