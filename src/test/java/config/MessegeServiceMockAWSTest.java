package config;

import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.model.GetQueueUrlResult;
import org.junit.Before;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

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
