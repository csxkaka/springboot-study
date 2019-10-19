package com.csxkaka.springbootstudy.beetl.dao;

import com.csxkaka.springbootstudy.beetl.entity.AccountBt;
import org.beetl.sql.core.annotatoin.SqlResource;
import org.beetl.sql.core.mapper.BaseMapper;

import java.util.List;

/**
 * md文件默认是在/sql下，所以这里不能写成：@SqlResource(sql.accountBt)
 */
@SqlResource("accountBt")
public interface AccountBtDao extends BaseMapper<AccountBt> {

    // 在sql/accountBt.md文件下写sql语句
    List<AccountBt> findAccountByIds(String name);
}
