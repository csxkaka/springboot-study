package com.csxkaka.springbootstudy.beetl.entity;

import org.beetl.sql.core.annotatoin.Table;

/**
 * SpringBoot 集成beetlsql
 * 如果要使用beetlsql的BaseMapper<>
 * 则当实体类名字和表名一致时，不需要@Table,否则需要
 * @Table是beetl的，别导错包
 */
@Table(name = "account")
public class AccountBt {

    private Integer id;
    private String name;
    private double money;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }
}
