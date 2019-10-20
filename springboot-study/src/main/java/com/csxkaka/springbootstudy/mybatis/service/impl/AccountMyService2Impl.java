package com.csxkaka.springbootstudy.mybatis.service.impl;

import com.csxkaka.springbootstudy.mybatis.dao.AccountMyDao2;
import com.csxkaka.springbootstudy.mybatis.service.AccountMyService2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 事物：
 *  1.只有在运行时异常或Error时，才会回滚事物
 *  2.在类或者实现类的方法上加@Transactional，这个类必须有@Service,@Component等
 *  3.注解的方法必须是public
 *  4.mysql MyISAM引擎不支持事物回滚
 *  5.事物只在本方法有效，其他方法调用此方法无效
 *  6.事物属性很多，具体参考文档
 */
@Service
public class AccountMyService2Impl implements AccountMyService2 {

    @Autowired
    private AccountMyDao2 accountMyDao2;

    @Transactional
    @Override
    public int update(double money, int id) {

        int row = accountMyDao2.update(money, id);
        throw new RuntimeException();
    }
}
