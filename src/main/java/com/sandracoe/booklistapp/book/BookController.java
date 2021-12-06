package com.sandracoe.booklistapp.book;

import java.util.List;

import com.sandracoe.booklistapp.Objects.BookObj;
import com.sandracoe.booklistapp.Objects.CategoryObj;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {
    
    @Autowired
    BookService service;

    @RequestMapping("/books")
    public List<BookObj> getAllBooks() {
        return service.getAllBooks();
    }
    @RequestMapping(method = RequestMethod.POST, value = "/books")
    public void addBook(@RequestBody Book book) {
        service.addBook(book);
    }
    @RequestMapping(method = RequestMethod.PUT, value = "/books/{id}")
    public void updateBook(@RequestBody Book book, @PathVariable Integer id) {
        service.updateBook(book);
    }
    @RequestMapping(method = RequestMethod.DELETE, value = "/books/{id}")
    public void removeBook(@PathVariable Integer id) {
        service.removeBook(id);
    }
     // Assign category
     @RequestMapping(method = RequestMethod.POST, value = "/books/{id}/category/{categoryId}")
     public void assignCategory(@PathVariable Integer id, @PathVariable Integer categoryId) {
         service.assignCategory(id, categoryId);
     }
     //see Categories
    @RequestMapping(value = "/books/{id}/category/")
    public List<CategoryObj> getBooks(@PathVariable Integer id) {
        return service.getCategories(id);
    }
    
}
