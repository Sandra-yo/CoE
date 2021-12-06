package com.sandracoe.booklistapp.users;

import java.util.ArrayList;
import java.util.List;

import com.sandracoe.booklistapp.book.Book;
import com.sandracoe.booklistapp.book.BookRepository;
import com.sandracoe.booklistapp.variables.Variables.EBook;
import com.sandracoe.booklistapp.variables.Variables.EUser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository repository;
    
    @Autowired
    BookRepository bookRepository;

    public List<Users> getAllUsers() {
        List<Users>  users = new ArrayList<Users>();
        repository.findAll()
        .forEach(users::add);
        return users;
    }
    public Users getUsers(Integer id) {  
        Users u = repository.findById(id).get();

        return new Users(u.getId(),u.getFirstName(),u.getLastName(),u.getCountry(),u.getRegistrationDate(),u.getUserName(),u.getPassword());
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

    // added a book
    public void addBookLiked(Integer id, Integer bookId) {
        Book book = bookRepository.findById(bookId).get();
        Users user = repository.findById(id).get();
        user.getBooksLiked().add(book);
        repository.save(user);
    }
    public List<Book> getBooks(Integer id) {
        Users user = repository.findById(id).get();
        return user.getBooksLiked();
    }

}
