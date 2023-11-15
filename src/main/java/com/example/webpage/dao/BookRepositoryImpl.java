package com.example.webpage.dao;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.webpage.Mapper.BookMapper;
import com.example.webpage.models.Book;

@Repository
public class BookRepositoryImpl implements BookRepositoryDao{
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int count() {
        return jdbcTemplate
                .queryForObject("select count(*) from books", Integer.class);
    }

    @Override
    public int save(Book book) {
        return jdbcTemplate.update(
                "insert into books (name, price) values(?,?)",
                book.getName(), book.getPrice());
    }

    @Override
    public int update(Book book) {
        return jdbcTemplate.update(
                "update books set price = ? where id = ?",
                book.getPrice(), book.getId());
    }


    @Override
    public int deleteById(Long id) {
        return jdbcTemplate.update(
                "delete from books where id = ?",
                id);
    }

    @Override
    public List<Book> findAll() {
        return jdbcTemplate.query(
                "select * from books",new BookMapper()
        );
    }

    // jdbcTemplate.queryForObject, populates a single object
    @Override
    public List<Book> findById(Long id) {
        // return jdbcTemplate.
        return jdbcTemplate.query(
                "select * from books where id = ?", new BookMapper(),id
        );
    }

    @Override
    public List<Book> findByNameAndPrice(String name, BigDecimal price) {
        return jdbcTemplate.query(
                "select * from books where name like ? and price <= ?",
                new Object[]{"%" + name + "%", price},
                (rs, rowNum) ->
                        new Book(
                                rs.getString("name"),
                                rs.getBigDecimal("price")
                        )
        );
    }

    @Override
    public String getNameById(Long id) {
        return jdbcTemplate.queryForObject(
                "select name from books where id = ?",
                new Object[]{id},
                String.class
        );
    }    
}
