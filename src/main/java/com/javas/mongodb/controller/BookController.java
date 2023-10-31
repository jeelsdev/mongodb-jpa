package com.javas.mongodb.controller;

import com.javas.mongodb.model.Book;
import com.javas.mongodb.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    protected BookService bookService;

    @GetMapping(value="/books",produces = "application/json")
    public List<Book> getProducts() {
        return  bookService.getAllItems();
    }

    @PostMapping(value = "/books")
    public ResponseEntity saveProduct(@RequestBody Book book){

        bookService.create(book);
        return new ResponseEntity(HttpStatus.OK);

    }
}
