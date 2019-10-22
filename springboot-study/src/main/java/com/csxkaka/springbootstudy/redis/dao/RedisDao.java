package com.csxkaka.springbootstudy.redis.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;

import java.util.concurrent.TimeUnit;

/**
 * SpringBoot 集成Redis
 *  通过StringRedisTemplate 或 RedisTemplate与redis数据库连接
 */

@Repository
public class RedisDao {

    @Autowired
    private StringRedisTemplate template;

    // 存入键值对
    public void setKey(String key, String value) {
        /**
         * 通过template.opsForValue()得到ValueOperations，这个接口中提供了很多redis对字符串的操作
         * 还可以得到很多其他的接口，比如对集合测操作，对hash的操作等等
         *  参考：https://blog.csdn.net/weixin_40461281/article/details/82011670
         */
        ValueOperations<String, String> ops = template.opsForValue();
        ops.set(key, value, 1, TimeUnit.MINUTES); // 一分钟过期
    }

    // 通过key得到值
    public String getValue(String key){
        return this.template.opsForValue().get(key);
    }
}
