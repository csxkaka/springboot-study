package com.csxkaka.springbootstudy;

import com.csxkaka.springbootstudy.mongodb.dao.CustomerRepository;
import com.csxkaka.springbootstudy.mongodb.entity.Customer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringbootStudyApplication.class)
public class MongoDbTest {

    @Autowired
    private CustomerRepository repository;

    @Test
    public void testDemo() {
        // 删除集合customer里的所有内容，如果存在
        repository.deleteAll();

        /**
         * 如果存在customer集合，直接在集合中添加
         * 如果不存在，则新创建集合customer,然后在添加
         * 如果需要指定新建的集合名称，在实体类加注解@Document(value="指定的集合名")
         *
         * 不需要指定id，会自动生成一个ObjectId
         * 不仅保存id，firstName,lastName,还会保存类名
         * 保存的完整格式：
         *     { "_id" : ObjectId("5dadc6d986330647e43cff78"),
         *     "firstName" : "Alice",
         *     "lastName" : "Smith",
         *     "_class" : "com.csxkaka.springbootstudy.mongodb.entity.Customer" }
         */
        repository.save(new Customer("Alice", "Smith"));
        repository.save(new Customer("Bob", "Smith"));

        System.out.println("-----findAll()---------");
        for (Customer customer : repository.findAll()) {
            System.out.println(customer);
        }
        /**
         * 输出时不会输出类名
         * 输出格式：
         *  Customer{id='5dadcb488633064f446f2b5e', firstName='Alice', lastName='Smith'}
         */

        System.out.println();
        System.out.println("-----findByFirstName()---");
        System.out.println(repository.findByFirstName("Alice"));
//        System.out.println(repository.findLastNameByFirstName("Alice"));

        System.out.println();
        System.out.println("-----findByLastName()----");
        for (Customer customer : repository.findByLastName("Smith")) {
            System.out.println(customer);
        }
    }
}
