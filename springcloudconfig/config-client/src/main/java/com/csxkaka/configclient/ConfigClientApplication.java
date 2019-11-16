package com.csxkaka.configclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableEurekaClient
@RestController
@SpringBootApplication
public class ConfigClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConfigClientApplication.class, args);
    }

    @Value("${foo}")
    String foo;

    @RequestMapping(value = "/hi")
    public String hi() {
        return foo;
    }

    /**
     *  访问http://localhost:8881/hi  即上面的接口，端口也是本项目的端口
     *  首先会去bootstrap.properties找到配置中心的服务名，即config-server
     *  由于config-client和config-server都被注册到了eureka-server
     *  所以可通过配置中心服务名也就是config-server，找到其下的配置文件
     *  从而得到git仓库地址，并访问仓库下的配置文件
     *  这个配置文件就是本服务(客户端)的名字+开发环境（dev/test/pro）.properties
     *  也就是config-client-dev.properties
     *  从而得到该配置文件的foo属性只
     */

}
