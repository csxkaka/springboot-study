package com.csxkaka.springbootstudy;

import com.csxkaka.springbootstudy.beans.ConfigBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

// springboot启动类
@SpringBootApplication
public class SpringbootStudyApplication {

    public static void main(String[] args) {
        // 启动
        SpringApplication.run(SpringbootStudyApplication.class, args);

        // 或者
//        SpringApplication app = new SpringApplication(SpringbootStudyApplication.class);
//        app.run(args);

        // 或者
        // 在项目主目录：mvn spring-boot:run 命令启动 (:后没有空格)

        // 或者
        // 在项目主目录：mvn clean, mvn package 然后cd到target文件 使用java -jar +项目jar包 启动
    }

}
