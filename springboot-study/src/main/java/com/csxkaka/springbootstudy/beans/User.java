package com.csxkaka.springbootstudy.beans;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;

/**
 * 在HelloController中添加注解
 * @EnableConfigurationProperties(User.class)
 */
//@Component
// 不要使用user，因为user是配置文件中默认的，即为当前计算机用户
@ConfigurationProperties(prefix = "user1")
@PropertySource(value = "classpath:config/test.properties")
public class User {

   private String name;
   private Integer age;

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
}
