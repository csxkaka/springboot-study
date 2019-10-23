package com.csxkaka.springbootstudy.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

/**
 * 测试使用spring官方的restdoc生成api文档
 */
@RestController
public class HomeController {

    @GetMapping("/home")
    public Map<String, Object> greeting() {
        return Collections.singletonMap("message", "Hello World");
    }
}
