package com.ascending.service;

import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.model.GetQueueUrlResult;
import com.amazonaws.services.sqs.model.SendMessageRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessegeService {
//    private String queueUrl = "https://sqs.us-east-1.amazonaws.com/243559352804/yan-luke";
    @Autowired
    private AmazonSQS sqs;
    Logger logger = LoggerFactory.getLogger(getClass());
    private String queueName = "yan-luke";
    public void sendMessege(String messegeBody,int delaySecond){
        // Send a message
        SendMessageRequest send_msg_request = new SendMessageRequest()
                .withQueueUrl(getQueueUrl(queueName))
                .withMessageBody(messegeBody)
                .withDelaySeconds(delaySecond);
        sqs.sendMessage(send_msg_request);
//        final SendMessageRequest sendMessageRequest = new SendMessageRequest(myQueueUrl, "This is my message text.");
//        sendMessageRequest.withQueueUrl(myQueueUrl).withMessageBody(msg);
//
//        final SendMessageResult sendMessageResult = sqsClient.sendMessage(sendMessageRequest);
//        final String sequenceNumber = sendMessageResult.getSequenceNumber();
//        final String messageId = sendMessageResult.getMessageId();
//        System.out.println("SendMessage succeed with messageId " + messageId + ", sequence number " + sequenceNumber + "\n");
////        public String getQueueResult(String queueName){
////            logger.info("QueueUrl: " + getQueueResult.getQueueUrl());
////        }
    }
    public String getQueueUrl(String queueName) {
        GetQueueUrlResult getQueueUrlResult = sqs.getQueueUrl(queueName);
        logger.info("QueueUrl: " + getQueueUrlResult.getQueueUrl());
        return getQueueUrlResult.getQueueUrl();
    }
}
