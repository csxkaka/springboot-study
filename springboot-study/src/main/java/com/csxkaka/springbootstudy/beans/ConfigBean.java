package com.csxkaka.springbootstudy.beans;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @ConfigurationProperties 将配置文件中的属性映射到该对象属性，必须填写前缀
 * @Component 将bean注入到IOC容器
 * 如果没有@Component，那么IOC容器找不到这个bean，无法将配置属性映射到这个bean，就会报错，
 * 要么在这里加@Component，
 * 要么在启动类加@EnableConfigurationProperties({ConfigBean.class}) // 大括号内的是必须的
 * 要么在业务类添加@EnableConfigurationProperties({ConfigBean.class})，
 * @EnableConfigurationProperties 注解其实是先将ConfigBean注入到IOC中了
 *
 * @PropertySource 指定从哪个文件加载配置属性，默认是在classpath目录下，
 * 只能加载properties属性文件，yml格式的不行，
 * 也可以引入外部配置文件
 */
@Component
@ConfigurationProperties(prefix = "my")
@PropertySource(value = "classpath:config/test.properties")
public class ConfigBean {

    private String name;
    private Integer age;
    private Integer number;
    private String uuid;
    private Integer max;
    private String value;
    private String greeting;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public Integer getMax() {
        return max;
    }

    public void setMax(Integer max) {
        this.max = max;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getGreeting() {
        return greeting;
    }

    public void setGreeting(String greeting) {
        this.greeting = greeting;
    }
}
