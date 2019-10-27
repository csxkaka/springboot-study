package com.csxkaka.springbootstudy.cache.entity;

import java.io.Serializable;

/**
 * SpringBoot 使用缓存
 *   实体类必须实现序列化，
 *   在启动类加@EnableCaching
 *   在实现方法上加@Cacheable
 */
public class Book implements Serializable {

    private String isbn;
    private String title;

    public Book(String isbn, String title) {
        this.isbn = isbn;
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
