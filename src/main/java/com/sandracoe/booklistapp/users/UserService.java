package com.sandracoe.booklistapp.users;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository repository;

    public List<Users> getAllBooks() {
        List<Users> categories = new ArrayList<Users>();
        repository.findAll()
        .forEach(categories::add);
        return categories;
    }

    public void addBook(Users book) {
        repository.save(book);
    }

    public void updateBook(Users book) {
        repository.save(book);
    }

    public void removeBook(String bookId) {
        repository.deleteById(bookId);
    }
}
