package com.sandracoe.booklistapp.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import com.sandracoe.booklistapp.Entities.Book;
import com.sandracoe.booklistapp.Entities.Users;
import com.sandracoe.booklistapp.Objects.BookObj;
import com.sandracoe.booklistapp.Objects.UserObj;
import com.sandracoe.booklistapp.Repositories.BookRepository;
import com.sandracoe.booklistapp.Repositories.UserRepository;
import com.sandracoe.booklistapp.Services.UserService;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
    @Spy
    private BookRepository bookRepositoryMock;

    @Spy
    private UserRepository userRepositoryMock;
    
    @InjectMocks
    private UserService serviceMock = new UserService();

    @Captor
    private ArgumentCaptor<Users> userArgumentCaptor;

    private Users user1 = new Users(1,
                                    "Sandra", 
                                    "Gonzalez", 
                                    "Mexico", 
                                    "December 6, 2021", 
                                    "SanGon", 
                                    "1979");
    private Users user2 = new Users(2,
                                    "Ulises", 
                                    "Gonzalez", 
                                    "Mexico", 
                                    "December 6, 2021", 
                                    "UliGon", 
                                    "1970");
    private UserObj u1 = new UserObj(user1);
    private UserObj u2 = new UserObj(user2);

    private Book book1 = new Book(1,
                                "The Dead Zone", 
                                "In 1953, a young boy named Johnny Smith suffers an accident while ice-skating; while recovering he mumbles -Don't jump it no more- to an adult on the scene", 
                                "unknow", 
                                "Stephen King", 
                                "12123212344", 
                                "1979");

    
    @Test
    @DisplayName("It should get all existing users")
    public void getAllUsers(){         
        //create return response from repository
        List<Users> users = Arrays.asList(user1,user2);
        
        //create return response from service
        List<UserObj> response = Arrays.asList(u1,u2);
        
        //adding action to return
        Mockito.when(userRepositoryMock.findAll()).thenReturn(users);
        
        //calling method         
        List<UserObj> booksResponse = serviceMock.getAllUsers();  

        Assertions.assertThat(booksResponse).isEqualTo(response);
        Assertions.assertThat(booksResponse.get(0).getFirstName()).isEqualTo("Sandra");
    }

    //Add a new user successfully
    @Test
    @DisplayName("It should add a new user")
    public void addBook(){                    
        serviceMock.addUser(user1);                   
        Mockito.verify(userRepositoryMock, Mockito.times(1)).save(userArgumentCaptor.capture());
        Assertions.assertThat(userArgumentCaptor.getValue().getFirstName()).isEqualTo("Sandra");
    }

    @Test
    @DisplayName("It should update an existing user")
    public void updateUser(){
        user1.setFirstName("Teresa");
        serviceMock.updateUser(user1);                   
        Mockito.verify(userRepositoryMock, Mockito.times(1)).save(userArgumentCaptor.capture());
        Assertions.assertThat(userArgumentCaptor.getValue().getFirstName()).isEqualTo("Teresa");
        Assertions.assertThat(userArgumentCaptor.getValue()).isEqualTo(user1);
    }

    @Test
    @DisplayName("It should remove an existing user")
    public void removeUser(){
        Mockito.when(userRepositoryMock.findById(user1.getId())).thenReturn(Optional.of(user1));
        serviceMock.removeUser(1);  
        Mockito.verify(userRepositoryMock, Mockito.times(1)).deleteById(1);
    }

    @Test
    @DisplayName("It shouldn't remove any user ")
    public void tryToRemoveAnUnexistingUser(){
        Mockito.when(userRepositoryMock.findById(5)).thenReturn(null);
        String response = serviceMock.removeUser(5);  
        Assertions.assertThat(response).contains("error: ");
    }

    @Test
    @DisplayName("It should add an existing book to an existing user ")
    public void addBookLiked(){
        Mockito.when(userRepositoryMock.findById(1)).thenReturn(Optional.of(user1));
        Mockito.when(bookRepositoryMock.findById(1)).thenReturn(Optional.of(book1)); 
        serviceMock.addBookLiked(1,1);
        Mockito.verify(userRepositoryMock, Mockito.times(1)).save(userArgumentCaptor.capture());
        Assertions.assertThat(userArgumentCaptor.getValue().getBooksLiked().get(0)).isEqualTo(book1);
    }

    @Test
    @DisplayName("It should fail to add an unexisting book to an existing user ")
    public void tryToaddAnUnexistingBook(){
        Mockito.when(bookRepositoryMock.findById(1)).thenReturn(null); 
        String response = serviceMock.addBookLiked(1,1);
        Assertions.assertThat(response).isEqualTo("verify if user or book already exist");
    }
    @Test
    @DisplayName("It should fail to add an existing book to an unexisting user ")
    public void tryToaddInUnexistingUser(){
        Mockito.when(userRepositoryMock.findById(1)).thenReturn(null);
        Mockito.when(bookRepositoryMock.findById(1)).thenReturn(Optional.of(book1)); 
        String response = serviceMock.addBookLiked(1,1);
        Assertions.assertThat(response).isEqualTo("verify if user or book already exist");
    }
    @Test
    @DisplayName("It should return the books liked from user")
    public void getBooksLiked(){
        List<Book> books = Arrays.asList(book1);
        user1.setBooksLiked(books);
        Mockito.when(userRepositoryMock.findById(1)).thenReturn(Optional.of(user1));
        List<BookObj> booksResponse =serviceMock.getBooks(1);
        Assertions.assertThat(booksResponse.get(0)).isEqualTo(new BookObj(book1));
    }

}
