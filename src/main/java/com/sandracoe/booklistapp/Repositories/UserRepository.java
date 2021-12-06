package com.sandracoe.booklistapp.Repositories;

import com.sandracoe.booklistapp.Entities.Users;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<Users, Integer> {
    
    
}
