package com.csxkaka.springbootstudy.mongodb.dao;

import com.csxkaka.springbootstudy.mongodb.entity.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CustomerRepository extends MongoRepository<Customer, String> {

    // 这里的方法名都不是随便写的，必须按照格式书写,具体需要参考文档
    public Customer findByFirstName(String firstName);

    public List<Customer> findByLastName(String lastName);

    // 这里不符合规范，运行时就会报错，mongodb操作的都是对象(集合),不能返回String
//    public String findLastNameByFirstName(String firstName);

}
