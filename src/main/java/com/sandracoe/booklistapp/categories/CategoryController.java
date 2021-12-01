package com.sandracoe.booklistapp.categories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CategoryController {
    
    @Autowired
    CategoryService service;

    @RequestMapping("/categories")
    public List<Category> getAllBooks() {
        return service.getAllBooks();
    }
    @RequestMapping(method = RequestMethod.POST, value = "/categories")
    public void addBook(@RequestBody Category book) {
        service.addBook(book);
    }
    @RequestMapping(method = RequestMethod.PUT, value = "/categories/{id}")
    public void updateBook(@RequestBody Category book, @PathVariable String id) {
        service.updateBook(book);
    }
    @RequestMapping(method = RequestMethod.DELETE, value = "/categories/{id}")
    public void removeBook(@PathVariable String id) {
        service.removeBook(id);
    }
}
