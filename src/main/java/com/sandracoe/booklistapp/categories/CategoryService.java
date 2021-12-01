package com.sandracoe.booklistapp.categories;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
    @Autowired
    CategoryRepository repository;

    public List<Category> getAllBooks() {
        List<Category> categories = new ArrayList<Category>();
        repository.findAll()
        .forEach(categories::add);
        return categories;
    }

    public void addBook(Category book) {
        repository.save(book);
    }

    public void updateBook(Category book) {
        repository.save(book);
    }

    public void removeBook(String bookId) {
        repository.deleteById(bookId);
    }
}
