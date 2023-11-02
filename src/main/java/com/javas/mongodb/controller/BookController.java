package com.javas.mongodb.controller;

import com.javas.mongodb.model.Book;
import com.javas.mongodb.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://127.0.0.1:5500", maxAge = 3600)
public class BookController {

    @Autowired
    protected BookService bookService;

    @CrossOrigin(origins = "http://127.0.0.1:5500")
    @GetMapping(value="/books",produces = "application/json")
    public List<Book> getBooks() {
        return  bookService.getAllBooks();
    }

    @PostMapping(value = "/books")
    public ResponseEntity saveBook(@RequestBody Book book){
        bookService.create(book);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PutMapping(value = "/book/{id}")
    public void update(@PathVariable String id,@RequestBody Book book) {
        bookService.update(id, book);
    }

    @DeleteMapping(value = "/book/{id}")
    public void delete(@PathVariable String id) {
        bookService.delete(id);
    }

    @GetMapping(value = "/book/{id}")
    public Optional<Book> getBook(@PathVariable String id) {

        return bookService.getBook(id);
    }
}
