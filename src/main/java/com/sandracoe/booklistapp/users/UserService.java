package com.sandracoe.booklistapp.users;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository repository;

    
    public List<Users> getAllUsers() {
        List<Users> users = new ArrayList<Users>();
        repository.findAll()
        .forEach(users::add);
        return users;
    }

    public void addUser(Users user) {
        repository.save(user);
    }

    public void updateUser(Users user) {
        repository.save(user);
    }

    public void removeUser(String userId) {
        repository.deleteById(userId);
    }

}
