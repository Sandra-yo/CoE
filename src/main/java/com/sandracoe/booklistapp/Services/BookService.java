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

    public String addBook(Book book) {
        try {
            repository.save(book);
            return "Book added successfully";
        } catch (Exception e) {
            return "error: "+ e;
        }
    }

    public String updateBook(Book book) {
        try {
            repository.save(book);
            return "Book updated successfully";
        } catch (Exception e) {
            return "error: "+e;
        } 
    }

    public String removeBook(Integer bookId) {
        try {
            Book book = repository.findById(bookId).get();
            if(!book.getUsers().isEmpty()){
                book.getUsers().clear();
               repository.save(book);
            }
            repository.deleteById(bookId);
               return "Book removed successfully";
           } catch (Exception e) {
               return "error: "+e;
           }
    }
    //assign a category
    public String assignCategory(Integer id, Integer categoryId) {
        try {
            Book book = repository.findById(id).get();
            Category category = categoryRepository.findById(categoryId).get();
            book.setCategories(category);
            repository.save(book);
            return "Category added successfully";
        } catch (Exception e) {
            return "verify if category or book already exist";
        }
    }

    //get category from book
    public List<CategoryObj> getCategories(Integer id) {
        try {
            Book book = repository.findById(id).get();
            List<CategoryObj> categories = new ArrayList<CategoryObj>();
            book.getCategories()
            .forEach(category ->{
                categories.add(new CategoryObj(category));
                }
            );
            return categories;
        } catch (Exception e) {
            return null;
        }
        
    }
}
