package com.csxkaka.springbootstudy.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * 配置第二个项目启动后执行的业务类
 * 查看springboot帮我们自动注册了哪些类
 */
//@Component
//@Order(2)
public class MyCommandLineRunner2 implements CommandLineRunner {

    @Autowired
    ApplicationContext ctx;

    @Override
    public void run(String... args) throws Exception {
        // 获取注册的bean的名字，包括我们自己配置的bean
        String[] beanNames =  ctx.getBeanDefinitionNames();
        Arrays.sort(beanNames);
        System.out.println("Let's inspect the beans provided by Spring Boot!");
        for (String beanName : beanNames) {
            System.out.println(beanName);
       }
    }
}
