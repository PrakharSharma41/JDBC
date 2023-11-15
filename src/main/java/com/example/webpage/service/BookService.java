package com.example.webpage.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.webpage.WebpageApplication;
import com.example.webpage.dao.BookRepositoryDao;
import com.example.webpage.models.Book;

@Service
public class BookService {

    @Autowired
    private BookRepositoryDao bookDao;    
    public List<Book> findAllMovies() {
        List<Book>ls=bookDao.findAll();
        return ls;
    }

    public int getCount() {
        return bookDao.count();
    }

    public int saveBook(Book book) {
        return bookDao.save(book);
    }

    public int updateBook(Book book) {
        return bookDao.save(book);
    }

    public int deleteBook(Integer deleteId) {
        return bookDao.deleteById((long)deleteId);
    }

    public List<Book> getBookById(Integer bookId){
        return bookDao.findById((long)bookId);
    }
}
