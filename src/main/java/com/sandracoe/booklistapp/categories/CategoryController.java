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
    public List<Category> getAllCategories() {
        return service.getAllCategories();
    }
    @RequestMapping(method = RequestMethod.POST, value = "/categories")
    public void addCategory(@RequestBody Category category) {
        service.addCategory(category);
    }
    @RequestMapping(method = RequestMethod.PUT, value = "/categories/{id}")
    public void updateCategory(@RequestBody Category category, @PathVariable String id) {
        service.updateCategory(category);
    }
    @RequestMapping(method = RequestMethod.DELETE, value = "/categories/{id}")
    public void removeCategory(@PathVariable String id) {
        service.removeCategory(id);
    }
}
