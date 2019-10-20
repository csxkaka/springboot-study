package com.csxkaka.springbootstudy.mybatis.controller;

import com.csxkaka.springbootstudy.mybatis.service.AccountMyService2;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 使用xml形式，集成mybatis，
 * 并添加事物
 */
@RestController
@RequestMapping("/account/mybatisTx/")
@MapperScan("com.csxkaka.springbootstudy.mybatis.dao")
public class AccountMyController2 {

    @Autowired
    private AccountMyService2 accountMyService2;

    // 在服务层添加事物
    @RequestMapping(value = "/updateMoney/{id}", method = RequestMethod.POST)
    public String updateMoney(@PathVariable("id") int id,
                              @RequestParam(value = "money", required = true) double money) {
        int row = accountMyService2.update(money, id);
        if (row > 0) {
            return "success";
        }
        return "fail";
    }
}
