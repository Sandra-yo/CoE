package com.sandracoe.booklistapp.Repositories;

import com.sandracoe.booklistapp.Entities.Authority;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Authority, Integer> {

    Authority findByName(String name);
    
}
