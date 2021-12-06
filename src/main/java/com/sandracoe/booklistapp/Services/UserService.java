package com.sandracoe.booklistapp.Services;

import java.util.ArrayList;
import java.util.List;

import com.sandracoe.booklistapp.Entities.Book;
import com.sandracoe.booklistapp.Entities.Users;
import com.sandracoe.booklistapp.Objects.BookObj;
import com.sandracoe.booklistapp.Objects.UserObj;
import com.sandracoe.booklistapp.Repositories.BookRepository;
import com.sandracoe.booklistapp.Repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository repository;
    
    @Autowired
    BookRepository bookRepository;

    public List<UserObj> getAllUsers() {
        List<UserObj>  users = new ArrayList<UserObj>();
        repository.findAll()
        .forEach(user ->{
            users.add(new UserObj(user));
            }
        );
        return users;
    }
    public UserObj getUsers(Integer id) {  
        try {
            UserObj user = new UserObj(repository.findById(id).get());
            return user;
        } catch (Exception e) {
            return null;
        }
    }

    public String addUser(Users user) {
        try {
            repository.save(user);
            return "User added successfully";
        } catch (Exception e) {
            return "error: "+ e;
        }
        
    }

    public String updateUser(Users user) {
        try {
            repository.save(user);
            return "User updated successfully";
        } catch (Exception e) {
            return "error: "+e;
        } 
    }

    public String removeUser(Integer userId) {
        try {
         Users user = repository.findById(userId).get();
         if(!user.getBooksLiked().isEmpty()){
            user.getBooksLiked().clear();
            repository.save(user);
         }
         repository.deleteById(userId);
            return "user removed successfully";
        } catch (Exception e) {
            return "error: "+e;
        }
        
    }

    // add a book
    public String addBookLiked(Integer id, Integer bookId) {
        try {
            Book book = bookRepository.findById(bookId).get();
            Users user = repository.findById(id).get();
            user.getBooksLiked().add(book);
            repository.save(user);
            return "book added successfully";
        } catch (Exception e) {
            return "verify if user or book already exist";
        }
    }
    //get book from the user
    public List<BookObj> getBooks(Integer id) {
        try {
            Users user = repository.findById(id).get();
            List<BookObj>  books = new ArrayList<BookObj>();
            user.getBooksLiked()
            .forEach(book ->{
                books.add(new BookObj(book));
                }
            );
            return books; 
        } catch (Exception e) {
            return null;
        }
        
    }
    

}
