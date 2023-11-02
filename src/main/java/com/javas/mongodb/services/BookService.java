package com.javas.mongodb.services;

import com.javas.mongodb.model.Book;
import com.javas.mongodb.model.CrudService;
import com.javas.mongodb.repository.BookRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
        ObjectId objectId = new ObjectId(id);
        book.setId(objectId);
        bookRepository.save(book);
    }

    @Override
    public void delete(String id) {
        ObjectId objectId = new ObjectId(id);
        bookRepository.deleteById(objectId);
    }

    @Override
    public Optional<Book> getBook(String id) {
        ObjectId objectId = new ObjectId(id);
        return bookRepository.findById(objectId);
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

}
