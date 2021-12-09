package com.sandracoe.booklistapp.Repositories;

import com.sandracoe.booklistapp.Entities.Book;

import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Integer> {
    
}
