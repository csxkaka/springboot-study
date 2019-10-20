package com.csxkaka.springbootstudy.mybatis.controller;

import com.csxkaka.springbootstudy.mybatis.dao.AccountMyDao;
import com.csxkaka.springbootstudy.mybatis.entity.AccountMy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * SpringBoot 集成Mybatis
 *
 *  1.添加依赖
 *  2.编写实体 主键默认是id，自增
 *  基于注解，不写xml映射文件：
 *      3.在dao上添加@Mapper注解
 *      4.在dao里面的方法上使用@Selete,@Update等注解，参数使用@Param注解，对应sql中的#{param}
 *
 *  基于xml文件：
 *      3.dao上面不添加@Mapper注解
 *      4.在配置文件配置：mybatis.mapper-locations:classpath:mybatis/*.xml，指明mapper映射文件的位置
 *          mybatis.type-aliases-package 指明实体类使用别名的包
 *      5.添加MapperScan(com.csxkaka...) 包扫描，应为dao层是没有添加@Mapper注解的，
 *          所以并没有被spring管理，通过包扫描，将扫到的接口被spring管理。
 *          可以在启动类添加，也可以在需要的地方添加
 *
 */
@RestController
@RequestMapping("/account/mybatis")
public class AccountMyController {

    // 省略了service层
    @Autowired
    private AccountMyDao accountMyDao;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public AccountMy findById(@PathVariable("id") int id) {
        return accountMyDao.findAccountMy(id);
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<AccountMy> findAccountList() {
        return accountMyDao.findAccountList();
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addAccount(@RequestParam(value = "name", required = true) String name,
                          @RequestParam(value = "money", required = true) double money) {
        int row = accountMyDao.add(name, money);
        if (row == 1) {
            return "success";
        }
        return "fail";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public String updateAccount(@PathVariable("id") int id,
                             @RequestParam(value = "name", required = true) String name,
                             @RequestParam(value = "money", required = true) double money) {
        int row = accountMyDao.update(name, money, id);
        if (row == 1) {
            return "success";
        }
        return "fail";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public String deleteAccount(@PathVariable("id") int id) {
        int row = accountMyDao.delete(id);
        if (row == 1) {
            return "success";
        }
        return "fail";
    }

}
