package com.csxkaka.springbootstudy.cache.repository;

import com.csxkaka.springbootstudy.cache.entity.Book;

public interface BookRepository {

    Book getByIsbn(String isbn);
}
