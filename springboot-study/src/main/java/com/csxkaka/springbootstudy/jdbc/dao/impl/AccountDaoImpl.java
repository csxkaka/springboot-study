package com.csxkaka.springbootstudy.jdbc.dao.impl;

import com.csxkaka.springbootstudy.jdbc.dao.AccountDao;
import com.csxkaka.springbootstudy.jdbc.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 这里不在配置文件里写sql语句，直接通过spring的JdbcTemplate与数据库交互
 */
@Repository
public class AccountDaoImpl implements AccountDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int add(Account account) {
       return jdbcTemplate.update("insert into account(name, money)values(?,?)",
               account.getName(),
               account.getMoney());
    }

    @Override
    public int update(Account account) {
        return jdbcTemplate.update("update account set name = ?, money = ? where id = ?",
                account.getName(), account.getMoney(), account.getId());
    }

    @Override
    public int delete(int id) {
        return jdbcTemplate.update("delete from account where id = ?", id);
    }

    @Override
    public Account findAccountById(int id) {
        // 其实只会查出一条数据
        List<Account> list = jdbcTemplate.query("select * from account where id = ?",
                new Object[]{id},
                new BeanPropertyRowMapper<>(Account.class));
        if (list != null && list.size() > 0) {
            return list.get(0);
        }
        return null;
    }

    @Override
    public List<Account> findAccountList() {
        List<Account> list = jdbcTemplate.query("select * from account",
                new Object[]{}, new BeanPropertyRowMapper<>(Account.class));
        if (list != null && list.size() > 0) {
            return list;
        }
        return null;
    }
}
