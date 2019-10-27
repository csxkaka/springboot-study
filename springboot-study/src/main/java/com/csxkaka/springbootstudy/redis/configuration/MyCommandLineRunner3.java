package com.csxkaka.springbootstudy.redis.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.CountDownLatch;

//@Component
public class MyCommandLineRunner3 implements CommandLineRunner {

    private static Logger logger = LoggerFactory.getLogger(MyCommandLineRunner3.class);

    @Autowired
    private ApplicationContext ctx;

    /**
     * 这个方法是在启动完毕后才执行的，所以这些bean都是可以拿到的
     * @param args
     * @throws Exception
     */
    @Override
    public void run(String... args) throws Exception {
        // 获取注入的bean
        StringRedisTemplate template = ctx.getBean(StringRedisTemplate.class);
        CountDownLatch latch = ctx.getBean(CountDownLatch.class);
        logger.info("Sending Message...");
        template.convertAndSend("chat", "Hello RedisMessage");
        latch.await();
        System.exit(0);
    }
}
