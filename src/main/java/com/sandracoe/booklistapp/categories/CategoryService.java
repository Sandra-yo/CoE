package com.sandracoe.booklistapp.categories;

import java.util.ArrayList;
import java.util.List;

import com.sandracoe.booklistapp.Objects.CategoryObj;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
    @Autowired
    CategoryRepository repository;

    public List<CategoryObj> getAllCategories() {
        List<CategoryObj> categories = new ArrayList<CategoryObj>();
        repository.findAll()
        .forEach(category->{
            categories.add(new CategoryObj(category));
        });
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
