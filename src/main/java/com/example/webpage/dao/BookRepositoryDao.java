package com.example.webpage.dao;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import com.example.webpage.models.Book;

public interface BookRepositoryDao {
    int count();

    int save(Book book);

    int update(Book book);

    int deleteById(Long id);

    List<Book> findAll();

    List<Book> findByNameAndPrice(String name, BigDecimal price);

    List<Book> findById(Long id);

    String getNameById(Long id);    
}
