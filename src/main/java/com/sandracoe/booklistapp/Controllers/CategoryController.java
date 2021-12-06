package com.sandracoe.booklistapp.Controllers;

import java.util.List;

import com.sandracoe.booklistapp.Entities.Category;
import com.sandracoe.booklistapp.Objects.CategoryObj;
import com.sandracoe.booklistapp.Services.CategoryService;

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
    public List<CategoryObj> getAllCategories() {
        return service.getAllCategories();
    }
    @RequestMapping(method = RequestMethod.POST, value = "/categories")
    public String addCategory(@RequestBody Category category) {
        return service.addCategory(category);
    }
    @RequestMapping(method = RequestMethod.PUT, value = "/categories/{id}")
    public String updateCategory(@RequestBody Category category, @PathVariable Integer id) {
        return service.updateCategory(category);
    }
    @RequestMapping(method = RequestMethod.DELETE, value = "/categories/{id}")
    public String removeCategory(@PathVariable Integer id) {
        return service.removeCategory(id);
    }
}
