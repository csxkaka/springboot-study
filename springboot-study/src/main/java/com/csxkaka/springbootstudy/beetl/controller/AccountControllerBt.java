package com.csxkaka.springbootstudy.beetl.controller;

import com.csxkaka.springbootstudy.beetl.dao.AccountBtDao;
import com.csxkaka.springbootstudy.beetl.entity.AccountBt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
