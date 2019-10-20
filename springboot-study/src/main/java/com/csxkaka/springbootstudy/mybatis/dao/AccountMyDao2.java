package com.csxkaka.springbootstudy.mybatis.dao;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

/**
 * 使用xml映射文件写sql，不添加@Mapper注解，
 * 映射文件命名空间为类的全名 com.csxkaka.springbootstudy.mybatis.dao.AccountMyDao2
 */
public interface AccountMyDao2 {

    // 映射文件id
    int update(@Param("money") double money, @Param("id") int id);
}
