package com.csxkaka.springbootstudy;

import com.csxkaka.springbootstudy.redis.dao.RedisDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringbootStudyApplication.class)
public class RedisTest {

    public static Logger logger = LoggerFactory.getLogger(RedisTest.class);

    @Autowired
    private RedisDao redisDao;

    @Test
    public void testRedis() {
        redisDao.setKey("name", "csx");
        redisDao.setKey("age", "25");
        logger.info(redisDao.getValue("age"));
        logger.info(redisDao.getValue("name"));
    }
}
