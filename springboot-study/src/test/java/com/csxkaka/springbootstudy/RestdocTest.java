package com.csxkaka.springbootstudy;

import com.csxkaka.springbootstudy.controllers.HomeController;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * restdocs是通过单元测试生成snippets文件，在根据插件生成html接口文档
 * @AutoConfigureRestDocs 开启生成snippets文件夹，并指定存放位置
 */
@RunWith(SpringRunner.class)
@WebMvcTest(HomeController.class)
@AutoConfigureRestDocs(outputDir = "target/snippets")
public class RestdocTest {

    @Autowired
    private MockMvc mockMvc;

    /**
     * 如果测试通过，则会在target下生成一个snippets文件夹，在snippets文件夹下面生成home文件夹，home文件夹是
     * 自己定义的。
     * home文件夹下面是几个.adoc文件：
     *      cui-request.adoc
     *      http-request.adoc
     *      http-response.adoc
     *      httpie-request.adoc
     *      ...
     *      ...
     *      adoc文件有一定的格式，具体参考文档
     * @throws Exception
     */
    @Test
    public void shouldReturnDefaultMessage() throws Exception {
        this.mockMvc.perform(get("/home")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("Hello World")))
                .andDo(document("home"));
    }
}
