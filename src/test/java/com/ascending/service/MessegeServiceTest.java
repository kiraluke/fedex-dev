package com.ascending.service;

import com.ascending.ApplicationBootsTrap;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ApplicationBootsTrap.class)
public class MessegeServiceTest {
    @Autowired
    private MessegeService messegeService;

    @Test
    public void sendMessegeTest(){
        messegeService.sendMessege("ascending",1);

    }
}
