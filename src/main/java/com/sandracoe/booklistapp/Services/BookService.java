package com.sandracoe.booklistapp.Services;

import java.util.ArrayList;
import java.util.List;

import com.sandracoe.booklistapp.Entities.Book;
import com.sandracoe.booklistapp.Entities.Category;
import com.sandracoe.booklistapp.Objects.BookObj;
import com.sandracoe.booklistapp.Objects.CategoryObj;
import com.sandracoe.booklistapp.Repositories.BookRepository;
import com.sandracoe.booklistapp.Repositories.CategoryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    @Autowired
    BookRepository repository;

    @Autowired
    CategoryRepository categoryRepository;

    public List<BookObj> getAllBooks() {
        List<BookObj> books = new ArrayList<BookObj>();
        repository.findAll()
        .forEach(book->{
            books.add(new BookObj(book));
        });
        return books;
    }

    public void addBook(Book book) {
        repository.save(book);
    }

    public void updateBook(Book book) {
        repository.save(book);
    }

    public void removeBook(Integer bookId) {
        repository.deleteById(bookId);
    }
    //assign a category
    public void assignCategory(Integer id, Integer categoryId) {
        Book book = repository.findById(id).get();
        Category category = categoryRepository.findById(categoryId).get();
        book.setCategories(category);
        repository.save(book);
    }

    //get category from book
    public List<CategoryObj> getCategories(Integer id) {
        Book book = repository.findById(id).get();
        List<CategoryObj> categories = new ArrayList<CategoryObj>();
        book.getCategories()
        .forEach(category ->{
            categories.add(new CategoryObj(category));
            }
        );
        return categories;
    }
}
