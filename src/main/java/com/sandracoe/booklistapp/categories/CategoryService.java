package com.sandracoe.booklistapp.categories;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
    @Autowired
    CategoryRepository repository;

    public List<Category> getAllCategories() {
        List<Category> categories = new ArrayList<Category>();
        repository.findAll()
        .forEach(categories::add);
        return categories;
    }

    public void addCategory(Category category) {
        repository.save(category);
    }

    public void updateCategory(Category category) {
        repository.save(category);
    }

    public void removeCategory(Integer CategoryId) {
        repository.deleteById(CategoryId);
    }
}
