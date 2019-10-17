package com.csxkaka.springbootstudy.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * CommandLineRunner 在springboot项目启动后执行
 * 可以配置多个类，都来实现这个接口，通过@Order来实现项目启动后业务的执行顺序
 * @Order 若设定具体的值，值越低优先级越高，
 * 若有一个没设置，则这个没设置的优先级最低，即默认最低优先级
 * 默认最低优先级：Ordered.LOWEST_PRECEDENCE，即int最小值
 * 若修改为Ordered.HIGHEST_PRECEDENCE，int最大值
 */
@Component
@Order(0)
public class MyCommandLineRunner1 implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        System.out.println("--------启动成功--------");
    }
}
