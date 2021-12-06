package com.sandracoe.booklistapp.Services;

import java.util.ArrayList;
import java.util.List;

import com.sandracoe.booklistapp.Entities.Category;
import com.sandracoe.booklistapp.Objects.CategoryObj;
import com.sandracoe.booklistapp.Repositories.CategoryRepository;

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

    public String addCategory(Category category) {
        try {
            repository.save(category);
            return "category added successfully";
        } catch (Exception e) {
            return "error: "+ e;
        }
    }

    public String updateCategory(Category category) {
        try {
            repository.save(category);
            return "Category added successfully";
        } catch (Exception e) {
            return "error: "+ e;
        }
    }

    public String removeCategory(Integer CategoryId) {
        try {
            Category category = repository.findById(CategoryId).get();
            if(!category.getBooks().isEmpty()){
                category.getBooks().clear();
               repository.save(category);
            }
            repository.deleteById(CategoryId);
               return "user removed successfully";
           } catch (Exception e) {
               return "error: "+e;
           }
    }
}
