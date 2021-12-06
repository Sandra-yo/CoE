package com.sandracoe.booklistapp.users;

import java.util.ArrayList;
import java.util.List;

import com.sandracoe.booklistapp.Objects.BookObj;
import com.sandracoe.booklistapp.Objects.UserObj;
import com.sandracoe.booklistapp.book.Book;
import com.sandracoe.booklistapp.book.BookRepository;

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
        UserObj user = new UserObj(repository.findById(id).get());
        return user;
    }

    public void addUser(Users user) {
        repository.save(user);
    }

    public void updateUser(Users user) {
        repository.save(user);
    }

    public void removeUser(Integer userId) {
        repository.deleteById(userId);
    }

    // add a book
    public void addBookLiked(Integer id, Integer bookId) {
        Book book = bookRepository.findById(bookId).get();
        Users user = repository.findById(id).get();
        user.getBooksLiked().add(book);
        repository.save(user);
    }
    //get book from the user
    public List<BookObj> getBooks(Integer id) {
        Users user = repository.findById(id).get();
        List<BookObj>  books = new ArrayList<BookObj>();
        user.getBooksLiked()
        .forEach(book ->{
            books.add(new BookObj(book));
            }
        );
        return books;
    }
    

}
