package com.sandracoe.booklistapp.book;

import java.util.List;

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
    public List<Book> getAllBooks() {
        return service.getAllBooks();
    }
    @RequestMapping(method = RequestMethod.POST, value = "/books")
    public void addBook(@RequestBody Book book) {
        service.addBook(book);
    }
    @RequestMapping(method = RequestMethod.PUT, value = "/books/{id}")
    public void updateBook(@RequestBody Book book, @PathVariable String id) {
        service.updateBook(book);
    }
    @RequestMapping(method = RequestMethod.DELETE, value = "/books/{id}")
    public void removeBook(@PathVariable String id) {
        service.removeBook(id);
    }
}
