package com.csxkaka.springbootstudy.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * 使用RestTemplate消费一个服务：http://gturnquist-quoters.cfapps.io/api/random
 * 这个服务随机返回一json字符串
 */
@Component
public class MyCommandLineRunner4 implements CommandLineRunner {

    private static Logger logger = LoggerFactory.getLogger(MyCommandLineRunner4.class);

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    @Bean
    public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
        return args -> {
            // 访问并返回一个字符串
            String quote = restTemplate.getForObject(
                    "http://gturnquist-quoters.cfapps.io/api/random", String.class);
            logger.info(quote.toString());
        };
    }

    @Override
    public void run(String... args) throws Exception {

    }
}
