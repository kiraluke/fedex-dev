package com.ascending.service;

import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClientBuilder;
import com.amazonaws.services.sqs.model.SendMessageRequest;
import com.amazonaws.services.sqs.model.SendMessageResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessegeService {

    private AmazonSQS amazonSQS;
    Logger logger = LoggerFactory.getLogger(getClass());
    private String myQueueUrl = "https://sqs.us-east-1.amazonaws.com/243559352804/car-demo-dev";
    public void sendMessege(String msg){
        AmazonSQS sqsClient = AmazonSQSClientBuilder.standard().build();
        // Send a message
        final SendMessageRequest sendMessageRequest = new SendMessageRequest(myQueueUrl, "This is my message text.");
        sendMessageRequest.withQueueUrl(myQueueUrl).withMessageBody(msg);

        final SendMessageResult sendMessageResult = sqsClient.sendMessage(sendMessageRequest);
        final String sequenceNumber = sendMessageResult.getSequenceNumber();
        final String messageId = sendMessageResult.getMessageId();
        System.out.println("SendMessage succeed with messageId " + messageId + ", sequence number " + sequenceNumber + "\n");
//        public String getQueueResult(String queueName){
//            logger.info("QueueUrl: " + getQueueResult.getQueueUrl());
//        }
    }
}
