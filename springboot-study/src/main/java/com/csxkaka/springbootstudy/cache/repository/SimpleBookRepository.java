package com.csxkaka.springbootstudy.cache.repository;

import com.csxkaka.springbootstudy.cache.entity.Book;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

@Component
public class SimpleBookRepository implements BookRepository {

    @Override
    @Cacheable("books") // 给该缓存取名字
    public Book getByIsbn(String isbn) {
        /**
         * 测试用的
         *   开启缓存后，第一次走了getByIsbn这个方法，之后都没有走，直接走的缓存
         *   所以第一次等待了3秒，之后都没等
         */
        simulateSlowService();
        return new Book(isbn, "Some Book!");
    }

    // Don't do this at home
    private void simulateSlowService() {
        try {
            long time = 3000L;
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new IllegalStateException(e);
        }
    }
}
