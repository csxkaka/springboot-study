package com.csxkaka.springbootstudy.controllers;

import com.csxkaka.springbootstudy.beans.ConfigBean;
import com.csxkaka.springbootstudy.beans.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @RestController = @Controller + @ResponseBody
 */
@RestController("/hello")
@EnableConfigurationProperties({ConfigBean.class,User.class})
public class HelloController {

    @Autowired
    ConfigBean configBean;
    @Autowired
    User user;

    // value注解直接获取配置文件的配置属性
    @Value("${my.name}")
    private String name;

    @Value("${my.age}")
    private Integer age;

    @RequestMapping("")
    public String hello() {
        return "Hello Spring Boot";
    }

    @RequestMapping("/myInfo")
    public String myInfo() {
        return name + ": " + age;
    }

    /**
     * 通过ConfigBean获取配置文件信息。
     * @RequestMapping 可以直接写url，也可以通过如下方式，并可以指定请求类型
     * @return
     */
    @RequestMapping(value = "/findInfo", method = RequestMethod.GET)
    public String getFromConfigBean() {
        return configBean.getGreeting() + ">>>max: "
                + configBean.getMax() + ">>>value: "
                + configBean.getValue() + ">>>age: "
                + configBean.getAge();
    }

    @RequestMapping("/userInfo")
    public String getUserInfo() {
        return this.user.getName() + ":" + this.user.getAge();
    }
}
