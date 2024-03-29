package com.csxkaka.springbootstudy;

import com.csxkaka.springbootstudy.upload.storage.StorageProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.annotation.EnableCaching;

// springboot启动类
@SpringBootApplication
@EnableCaching
@EnableConfigurationProperties(StorageProperties.class)
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
