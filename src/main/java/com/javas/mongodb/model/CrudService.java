package com.javas.mongodb.model;

import java.util.List;
import java.util.Optional;

public interface CrudService<T> {
    public abstract void create(T t );
    public abstract void update(String id, T t);
    public abstract void delete(String id);
    public abstract Optional<Book> getBook(String id);

    public abstract List<T> getAllBooks();
}
