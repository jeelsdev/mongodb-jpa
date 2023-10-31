package com.javas.mongodb.services;

import com.javas.mongodb.model.Book;
import com.javas.mongodb.model.CrudService;
import com.javas.mongodb.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
@EnableMongoRepositories("com.javas.mongodb.repository")
public class BookService implements CrudService<Book> {

    @Autowired
    BookRepository bookRepository;

    @Override
    public void create(Book book) {
        bookRepository.save(book);
    }

    @Override
    public void update(String id, Book book) {
    }

    @Override
    public void delete(String id) {
    }

    @Override
    public Collection<Book> getItem() {
        return null;
    }

    @Override
    public List<Book> getAllItems() {
        return bookRepository.findAll();
    }

}
