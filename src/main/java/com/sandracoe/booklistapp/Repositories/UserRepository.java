package com.sandracoe.booklistapp.Repositories;

import java.util.List;

import com.sandracoe.booklistapp.Entities.Users;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<Users, Integer> {
    
    List<Users> findByUserName(String user);
    
}
