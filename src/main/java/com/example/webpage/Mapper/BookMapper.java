package com.example.webpage.Mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.example.webpage.models.Book;

public class BookMapper implements RowMapper<Book>{

    @Override
    public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Book(
            rs.getString("name"),
            rs.getBigDecimal("price")
        );
    }
    
}
