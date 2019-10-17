package com.csxkaka.springbootstudy.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * 配置第二个项目启动后执行的业务类
 * 查看springboot帮我们自动注册了哪些类
 */

/**
 * 函数式接口：jdk1.8新特性
 * CommandLineRunner是一个函数式接口，使用@FunctionalInterface注解
 * 函数式接口特点：
 * 有且只有一个抽象方法，
 * 可以有静态方法(static) 有方法体，
 * 可以有默认方法(default) 有方法体,
 * 可以有Object的public方法
 */
@Component
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

    /**
     * 也可以这样获取beans
     * @param ctx
     * @return
     */
    //@Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {
            String[] beanNames =  ctx.getBeanDefinitionNames();
            Arrays.sort(beanNames);
            for (String beanName : beanNames) {
                System.out.println(beanName);
            }
        };
    }
}
