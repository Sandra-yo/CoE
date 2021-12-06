package com.sandracoe.booklistapp.users;

import java.util.List;
import com.sandracoe.booklistapp.book.Book;

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
    public List<Users> getAllUsers() {
        return service.getAllUsers();
    }
    @RequestMapping(value = "/users/{id}")
    public Users getUser(@PathVariable Integer id) {
       return service.getUsers(id);

    }
    @RequestMapping(method = RequestMethod.POST, value = "/users")
    public void addUser(@RequestBody Users user) {
        service.addUser(user);
    }
    @RequestMapping(method = RequestMethod.PUT, value = "/users/{id}")
    public void updateUser(@RequestBody Users user, @PathVariable Integer id) {
        service.updateUser(user);
    }
    @RequestMapping(method = RequestMethod.DELETE, value = "/users/{id}")
    public void removeUser(@PathVariable Integer id) {
        service.removeUser(id);
    }
    // Added books
    @RequestMapping(method = RequestMethod.POST, value = "/users/{id}/book/{bookId}")
    public void addBookLiked(@PathVariable Integer id, @PathVariable Integer bookId) {
        service.addBookLiked(id, bookId);
    }
    //see books
    @RequestMapping(value = "/users/{id}/book/")
    public List<Book> getBooks(@PathVariable Integer id) {
        return service.getBooks(id);
    }
    
}
