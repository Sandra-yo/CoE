package com.sandracoe.booklistapp.users;

import java.util.List;

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
    @RequestMapping(method = RequestMethod.POST, value = "/users")
    public void addUser(@RequestBody Users user) {
        service.addUser(user);
    }
    @RequestMapping(method = RequestMethod.PUT, value = "/users/{id}")
    public void updateUser(@RequestBody Users user, @PathVariable String id) {
        service.updateUser(user);
    }
    @RequestMapping(method = RequestMethod.DELETE, value = "/users/{id}")
    public void removeUser(@PathVariable String id) {
        service.removeUser(id);
    }
}
