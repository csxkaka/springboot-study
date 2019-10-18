package com.csxkaka.springbootstudy;

/**
 * 静态导入 import static:
 *  这里导入的是一个类中的静态成员，一般都是静态方法，静态成员也可以，但最好不用
 *  import static org.junit.Assert.assertThat; 导入这一个静态方法，然后可以直接使用该方法，
 *  而不需要通过类名点方法的形式。
 *  import static org.junit.Assert.*; 导入Assert类中的所有静态成员。
 */

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * @RunWith(SpringRunner.class) 表示要进行spring的全部流程启动，类似于正常启动
 * 使用随机的端口启动，也可以是DEFINED_PORT 表示默认端口
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SpringbootStudyApplicationTests {

    // 获取当前端口号 也可以通过@Value("${local.server.port}")获取
    // 虽然没有在配置文件中配置，但这是springboot配置文件默认的，类似的默认属性还有很多
    @LocalServerPort
    private int port;

    private URL base;

    /**
     * TestRestTemplate 主要用于测试url请求后返回来的结果测试,
     * 包括get,post,delete,put...等等请求，每种请求方式都有对应的获取响应实体的方法
     */
    @Autowired
    private TestRestTemplate template;

    @Before
    public void beforeTest() throws MalformedURLException {
        // 先设url
        this.base = new URL("http://localhost:" + port + "/");
    }

    @Test
    public void contextLoads() {
        // template.getForEntity()会执行请求
        ResponseEntity<String> response = template.getForEntity(base.toString(), String.class);
        /**
         * 如果相等，则不会有输出
         * 如果不相等，则会报错，如下：
         *   java.lang.AssertionError:
         *   Expected: "Hllo Spring Boot"
         *        but: was "Hello Spring Boot"
         *   Expected :Hllo Spring Boot
         *   Actual   :Hello Spring Boot
         */
        assertThat(response.getBody(), equalTo("Hllo Spring Boot"));
    }

}
