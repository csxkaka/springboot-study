package com.csxkaka.springbootstudy.jdbc.controller;

import com.csxkaka.springbootstudy.jdbc.entity.Account;
import com.csxkaka.springbootstudy.jdbc.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * SpringBoot 整合jdbc
 * 通过JdbcTemplate连接数据库
 */
@RestController
@RequestMapping("/account/jdbc")
public class AccountController {

    @Autowired
    private AccountService accountService;

    // 查询所有
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<Account> findAccountList() {
        List<Account> list = accountService.findAccountList();
        return list;
    }

    // 根据id查单个对象
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Account findAccountById(@PathVariable("id") int id) {
        return accountService.findAccountById(id);
    }

    // 根据id设置name和money
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public String updateById(@PathVariable("id") int id,
                             @RequestParam(value = "name", required = true) String name,
                             @RequestParam(value = "money", required = true) double money) {
        Account account = new Account();
        account.setId(id);
        account.setName(name);
        account.setMoney(money);

        int row = accountService.update(account);
        if (row == 1) {
            return account.toString();
        }
        return "fail";
    }

    // 添加

    /**
     * 在浏览器中输入的url，只支持get请求，其他请求都进不来，可以使用postman测试
     * @param name
     * @param money
     * @return
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addAccount(@RequestParam("name") String name, @RequestParam("money") double money) {
        Account account = new Account();
        account.setName(name);
        account.setMoney(money);

        int row = accountService.add(account);
        if (row == 1) {
            return account.toString();
        }
        return "fail";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public String deleteById(@PathVariable("id") int id) {
       return Integer.valueOf(accountService.delete(id)).toString();
    }
}
