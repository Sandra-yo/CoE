package com.sandracoe.booklistapp.Repositories;

import java.util.List;

import com.sandracoe.booklistapp.Entities.Book;
import com.sandracoe.booklistapp.Entities.Category;

import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Integer> {
    
}
