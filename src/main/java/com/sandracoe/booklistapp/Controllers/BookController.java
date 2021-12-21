package com.sandracoe.booklistapp.Controllers;

import java.util.List;

import com.sandracoe.booklistapp.Entities.Book;
import com.sandracoe.booklistapp.Objects.BookObj;
import com.sandracoe.booklistapp.Objects.BookWithCategories;
import com.sandracoe.booklistapp.Objects.CategoryObj;
import com.sandracoe.booklistapp.Services.BookService;

import java.util.stream.Stream;
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
    public String addBook(@RequestBody Book book) {
        return service.addBook(book);
    }
    @RequestMapping(method = RequestMethod.PUT, value = "/books/{id}")
    public String updateBook(@RequestBody Book book, @PathVariable Integer id) {
        return service.updateBook(book);
    }
    @RequestMapping(method = RequestMethod.DELETE, value = "/books/{id}")
    public String removeBook(@PathVariable Integer id) {
        return service.removeBook(id);
    }
     // Assign category
     @RequestMapping(method = RequestMethod.POST, value = "/books/{id}/category/{categoryId}")
     public String assignCategory(@PathVariable Integer id, @PathVariable Integer categoryId) {
         return service.assignCategory(id, categoryId);
     }
     //see Categories
    @RequestMapping(value = "/books/{id}/category/")
    public List<CategoryObj> getBooks(@PathVariable Integer id) {
        return service.getCategories(id);
    }
    //books filtered by author
    @RequestMapping(value = "/books/author/{author}")
    public Stream<BookObj> getBooksByAuthor(@PathVariable String author) {
        return service.getBooksByAuthor(author);
    }

    //books published this year
    @RequestMapping(value = "/books/{year}")
    public Stream<BookObj> getBooksFromYear(@PathVariable int year) {
        return service.getBooksFromYear(year);
    }
    //books filtered by category
    @RequestMapping(value = "/books/category/{category}")
    public List<BookObj> getBooksFromCategory(@PathVariable int category) {
        return service.getBooksFromCategory(category);
    }
     //oldest book
     @RequestMapping(value = "/books/oldest")
     public BookWithCategories getOldestBook() {
         return service.getOldestBook();
     }
}
