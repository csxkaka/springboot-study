package com.csxkaka.springbootstudy.mybatis.dao;

import com.csxkaka.springbootstudy.mybatis.entity.AccountMy;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @Mapper 将dao交给spring管理，不用谢映射文件
 */
@Mapper
public interface AccountMyDao {

    @Insert("insert into account(name, money) value(#{name}, #{money}) ")
    int add(@Param("name") String name, @Param("money") double money);

    @Update("update account set name = #{name}, money = #{money} where id = #{id}")
    int update(@Param("name") String name, @Param("money") double money, @Param("id") int id);

    // 一个参数可以不写@Param
    @Delete("delete from account where id = #{id}")
    int delete(int id);

    @Select("select * from account where id = #{id}")
    AccountMy findAccountMy(@Param("id") int id);

    @Select("select * from account")
    List<AccountMy> findAccountList();
}
