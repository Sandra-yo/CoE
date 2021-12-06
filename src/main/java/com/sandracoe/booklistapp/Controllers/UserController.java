package com.sandracoe.booklistapp.Controllers;

import java.util.List;

import com.sandracoe.booklistapp.Entities.Users;
import com.sandracoe.booklistapp.Objects.BookObj;
import com.sandracoe.booklistapp.Objects.UserObj;
import com.sandracoe.booklistapp.Services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    
    @Autowired
    UserService service;

    @RequestMapping("/users")
    public List<UserObj> getAllUsers() {
        return service.getAllUsers();
    }
    @RequestMapping(value = "/users/{id}")
    public UserObj getUser(@PathVariable Integer id) {
       return service.getUsers(id);

    }
    @RequestMapping(method = RequestMethod.POST, value = "/users")
    public String addUser(@RequestBody Users user) {
        return service.addUser(user);
    }
    @RequestMapping(method = RequestMethod.PUT, value = "/users/{id}")
    public String updateUser(@RequestBody Users user, @PathVariable Integer id) {
        return service.updateUser(user);
    }
    @RequestMapping(method = RequestMethod.DELETE, value = "/users/{id}")
    public String removeUser(@PathVariable Integer id) {
        return service.removeUser(id);
    }
    // Added books
    @RequestMapping(method = RequestMethod.POST, value = "/users/{id}/book/{bookId}")
    public String addBookLiked(@PathVariable Integer id, @PathVariable Integer bookId) {
        return service.addBookLiked(id, bookId);
    }
    //see books
    @RequestMapping(value = "/users/{id}/book/")
    public List<BookObj> getBooks(@PathVariable Integer id) {
        return service.getBooks(id);
    }
    
}
