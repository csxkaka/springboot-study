package com.csxkaka.springbootstudy.jpa.controller;

import com.csxkaka.springbootstudy.jpa.dao.AccountDao;
import com.csxkaka.springbootstudy.jpa.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 集成jpa
 * 同一个项目中，不能有同名的类被@Controller修饰
 * 这里如果是AccountController，则项目启动失败
 */
@RestController
@RequestMapping("/account/jpa")
public class AccountJpaController {

    // 这里省略了service层，实际开发不可省
    @Autowired
    AccountDao accountDao;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<Account> getAccounts() {
        return accountDao.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Account getAccountById(@PathVariable("id") int id) {
        Account a = accountDao.findById(id).get();
        return accountDao.getOne(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public String updateAccount(@PathVariable("id") int id,
                                @RequestParam(value = "name", required = true) String name,
                                @RequestParam(value = "money", required = true) double money) {
        Account account = new Account();
        account.setId(id);
        account.setMoney(money);
        account.setName(name);

        return accountDao.saveAndFlush(account).toString();
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String postAccount(@RequestParam(value = "name", required = true) String name,
                              @RequestParam(value = "money", required = true) double money) {
        Account account = new Account();
        account.setName(name);
        account.setMoney(money);

        Account account1 = accountDao.save(account);
        return account1.toString();
    }
}
