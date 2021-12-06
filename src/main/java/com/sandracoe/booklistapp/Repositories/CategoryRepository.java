package com.sandracoe.booklistapp.Repositories;

import com.sandracoe.booklistapp.Entities.Category;

import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Integer> {
    
}
