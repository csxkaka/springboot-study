package com.csxkaka.springbootstudy.mongodb.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * mongonDb 默认集合名为实体类名小写
 * // 如果需要指定该实体对应的集合名，则使用@Document(value="")
 */
//@Document(value = "collectionName")
public class Customer {

    // 不加注解，mongoId也会自动生成ObjectId
    @Id
    public String id;
    public String firstName;
    public String lastName;

    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
