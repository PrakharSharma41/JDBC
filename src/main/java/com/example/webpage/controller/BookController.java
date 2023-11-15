package com.example.webpage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.webpage.models.Book;
import com.example.webpage.service.BookService;
@RestController
@RequestMapping(path="/api/v1/movies")
public class BookController {

    @Autowired
    BookService bookService;
    
    @GetMapping
    @ResponseBody
    public List<Book> getBooks(){
        System.out.println("getting books");
        return bookService.findAllMovies();
    }

    @GetMapping("/count")
    public int getCount(){
        return bookService.getCount();
    }

    @PostMapping
    public int saveBook(@RequestBody Book book){
        return bookService.saveBook(book);
    }
    @PutMapping("/{id}")
    public int updateBook(@RequestBody Book book){
        return bookService.updateBook(book);
    }
    @DeleteMapping("/{id}")
    public int deleteBook(@PathVariable("id")Integer deleteId){
        return bookService.deleteBook(deleteId);
    }

    @GetMapping("/{id}")
    public List<Book> getBookById(@PathVariable("id") Integer bookId){
        return bookService.getBookById(bookId);
    }

}
