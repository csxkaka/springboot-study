package com.csxkaka.springbootstudy.beetl.controller;

import com.csxkaka.springbootstudy.beetl.dao.AccountBtDao;
import com.csxkaka.springbootstudy.beetl.entity.AccountBt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * SpringBoot 集成beetl
 *  1.添加依赖
 *  2.配置数据源，像mybatis这种，只要在配置文件配置就可以连接数据库，但beetl还不能，
 *    需要配置一个DataSource bean
 *  3.在配置文件配置 beetlsql.sqlPath 和basePackage
 *  3.创建实体
 *  4.在dao层添加注解@SqlResource()指明该dao层对应的sql文件名
 *  5.dao集成BaseMapper<T>，实体类添加@Table(name="")，如果和表名一致可不写
 */
@Controller
@RequestMapping("/account/beetl")
public class AccountControllerBt {

    @Autowired
    private AccountBtDao accountBtDao;

    @RequestMapping("/list")
    @ResponseBody
    public List<AccountBt> findAll() {
        return accountBtDao.all();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    @ResponseBody
    public Integer updateById(@PathVariable("id") int id,
                              @RequestParam(value = "name", required = true) String name,
                              @RequestParam(value = "money", required = true) double money) {
        AccountBt accountBt = new AccountBt();
        accountBt.setName(name);
        accountBt.setMoney(money);
        accountBt.setId(id);
        return accountBtDao.updateById(accountBt);
    }

    @RequestMapping("/findByIds/{name}")
    @ResponseBody
    public List<AccountBt> findAccountByName(@PathVariable("name") String name) {
        return accountBtDao.findAccountByIds(name);
    }

}
