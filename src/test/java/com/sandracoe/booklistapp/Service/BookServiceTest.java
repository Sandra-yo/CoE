package com.sandracoe.booklistapp.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import com.sandracoe.booklistapp.Entities.Book;
import com.sandracoe.booklistapp.Entities.Category;
import com.sandracoe.booklistapp.Objects.BookObj;
import com.sandracoe.booklistapp.Objects.CategoryObj;
import com.sandracoe.booklistapp.Repositories.BookRepository;
import com.sandracoe.booklistapp.Repositories.CategoryRepository;
import com.sandracoe.booklistapp.Services.BookService;

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
public class BookServiceTest {
    @Spy
    private BookRepository repositoryMock;

    @Spy
    private CategoryRepository categoryRepositoryMock;
    
    @InjectMocks
    private BookService serviceMock = new BookService();
    
    @Captor
    private ArgumentCaptor<Book> bookArgumentCaptor;

    //books
    private Book book1 = new Book(1,
                                "The Dead Zone", 
                                "In 1953, a young boy named Johnny Smith suffers an accident while ice-skating; while recovering he mumbles -Don't jump it no more- to an adult on the scene", 
                                "unknow", 
                                "Stephen King", 
                                "12123212344", 
                                "1979");

    private Book book2 = new Book(2,
                                "Diary of a Wimpy Kid", 
                                "Greg Heffley, the middle school protagonist, clarifies that 'this is a JOURNAL, not a diary.' He then explains that he only agreed to write in one for when he is 'rich and famous,' and 'for now, I'm stuck in middle school with a bunch of morons.'", 
                                "Amulet Books", 
                                "Jeff Kinney", 
                                "12120114", 
                                "April 1, 2007");

    private BookObj b1 = new BookObj(book1);
    private BookObj b2 = new BookObj(book2);

    Category category1 = new Category(1,"Horror");
    Category category2 = new Category(2,"Comedy");


    @Test
    @DisplayName("It should get all existing books")
    public void getAllBooks(){         
        //create return response from repository
        List<Book> books = Arrays.asList(book1,book2);
        
        //create return response from service
        List<BookObj> response = Arrays.asList(b1,b2);
        
        //adding action to return
        Mockito.when(repositoryMock.findAll()).thenReturn(books);
        
        //calling method         
        List<BookObj> booksResponse = serviceMock.getAllBooks();  

        Assertions.assertThat(booksResponse).isEqualTo(response);
        Assertions.assertThat(booksResponse.get(0).getName()).isEqualTo("The Dead Zone");
    }

    @Test
    @DisplayName("It should add a new book")
    public void addBook(){                    
        serviceMock.addBook(book1);                   
        Mockito.verify(repositoryMock, Mockito.times(1)).save(bookArgumentCaptor.capture());
        Assertions.assertThat(bookArgumentCaptor.getValue().getName()).isEqualTo("The Dead Zone");
    }

    @Test
    @DisplayName("It should update an existing book")
    public void updateBook(){
        book1.setName("Dead Zone,the");
        serviceMock.updateBook(book1);                   
        Mockito.verify(repositoryMock, Mockito.times(1)).save(bookArgumentCaptor.capture());
        Assertions.assertThat(bookArgumentCaptor.getValue().getName()).isEqualTo("Dead Zone,the");
        Assertions.assertThat(bookArgumentCaptor.getValue()).isEqualTo(book1);
    }
    @Test
    @DisplayName("It should update an existing book")
    public void removeBook(){
        Mockito.when(repositoryMock.findById(book1.getId())).thenReturn(Optional.of(book1));
        serviceMock.removeBook(1);  
        Mockito.verify(repositoryMock, Mockito.times(1)).deleteById(1);
    }
    
    @Test
    @DisplayName("It should assign a category to an existing book")
    public void assignCategory(){
        Mockito.when(repositoryMock.findById(1)).thenReturn(Optional.of(book1));
        Mockito.when(categoryRepositoryMock.findById(1)).thenReturn(Optional.of(category1));
        serviceMock.assignCategory(1,1);  
        Mockito.verify(repositoryMock, Mockito.times(1)).save(bookArgumentCaptor.capture());
        Assertions.assertThat(bookArgumentCaptor.getValue().getCategories().get(0)).isEqualTo(category1);
    }

    @Test
    @DisplayName("It should return the categories of a book")
    public void getCategories(){
        List<CategoryObj> categoriesObj = Arrays.asList(new CategoryObj(category1),new CategoryObj(category2));
        List<Category> categoriesResponse = Arrays.asList(category1,category2);
        
        book1.setCategories(categoriesResponse);
        
        Mockito.when(repositoryMock.findById(1)).thenReturn(Optional.of(book1));
        List<CategoryObj> categories = serviceMock.getCategories(1);  
        Assertions.assertThat(categories).isEqualTo(categoriesObj);

         
    }


    
}
