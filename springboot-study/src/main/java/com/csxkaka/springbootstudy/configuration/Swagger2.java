package com.csxkaka.springbootstudy.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * springboot 继承swagger2
 * swagger配置，一般这样配置就可以了
 */
@Configuration   // 表明是一个配置类
@EnableSwagger2  // 开启Swaggers
//@EnableWebMvc
public class Swagger2 {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                // 配置一些基本信息
                .pathMapping("/")
                .apiInfo(apiInfo())
                .select()
                // apis()指定的包会生成api文档
                .apis(RequestHandlerSelectors.basePackage("com.csxkaka.springbootstudy.swagger2.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("springboot利用swagger2构建api文档")
                .description("对接口的描述")
                .version("1.0")
                .build();
    }
}
