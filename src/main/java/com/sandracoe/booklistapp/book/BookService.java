package com.sandracoe.booklistapp.book;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    @Autowired
    BookRepository repository;

    public List<Book> getAllBooks() {
        List<Book> books = new ArrayList<Book>();
        repository.findAll()
        .forEach(books::add);
        return books;
    }

    public void addBook(Book book) {
        repository.save(book);
    }

    public void updateBook(Book book) {
        repository.save(book);
    }

    public void removeBook(String bookId) {
        repository.deleteById(bookId);
    }
}
