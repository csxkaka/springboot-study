package com.csxkaka.springbootstudy.redis.message;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import java.util.concurrent.CountDownLatch;

/**
 * 一个普通的类，会注入到SpringBoot中
 */
public class Receiver {

    private static final Logger LOGGER = LoggerFactory.getLogger(Receiver.class);

    private CountDownLatch latch;

    @Autowired
    public Receiver(CountDownLatch latch) {
        this.latch = latch;
    }

    // 接受消息的方法
    public void receiveMessage(String message) {
        LOGGER.info("Receive<" + message + ">");
        latch.countDown();
    }
}
