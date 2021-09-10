package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.event.EventListener;

@SpringBootTest
class DemoApplicationTests {

    @Autowired
    private EmailSenderService service;

    @Test
    void contextLoads() {
        triggerMail();
    }

    @EventListener(ApplicationReadyEvent.class)
    public void triggerMail(){
        service.sendSimpleEmail("jasucorp@gmail.com","Register successfully","This is email Subject");


    }

}
