package com.sandracoe.booklistapp.Services;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.sandracoe.booklistapp.Entities.Book;
import com.sandracoe.booklistapp.Entities.Category;
import com.sandracoe.booklistapp.Objects.BookObj;
import com.sandracoe.booklistapp.Objects.BookWithCategories;
import com.sandracoe.booklistapp.Objects.CategoryObj;
import com.sandracoe.booklistapp.Repositories.BookRepository;
import com.sandracoe.booklistapp.Repositories.CategoryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    @Autowired
    BookRepository repository;

    @Autowired
    CategoryRepository categoryRepository;

    
    public List<BookObj> getAllBooks() {
        List<BookObj> books = new ArrayList<BookObj>();
        repository.findAll()
        .forEach(book->{
            books.add(new BookObj(book));
        });
        return books;
    }

    public String addBook(Book book) {
        //get cover
        BookCover cover = CoverService.getCover(book.getIsbn()); 
        //add
        book.setBookCover(cover.getUrl());
        try {
            repository.save(book);
            return "Book added successfully";
        } catch (Exception e) {
            return "error: "+ e;
        }
    }

    public String updateBook(Book book) {
        try {
            repository.save(book);
            return "Book updated successfully";
        } catch (Exception e) {
            return "error: "+e;
        } 
    }

    public String removeBook(Integer bookId) {
        try {
            Book book = repository.findById(bookId).get();
            if(!book.getUsers().isEmpty()){
                book.getUsers().clear();
               repository.save(book);
            }
            repository.deleteById(bookId);
               return "Book removed successfully";
           } catch (Exception e) {
               return "error: "+e;
           }
    }
    //assign a category
    public String assignCategory(Integer id, Integer categoryId) {
        try {
            Book book = repository.findById(id).get();
            Category category = categoryRepository.findById(categoryId).get();
            //book.setCategories();
            book.getCategories().add(category);
            repository.save(book);
            return "Category added successfully";
        } catch (Exception e) {
            return "verify if category or book already exist";
        }
    }

    //get category from book
    public List<CategoryObj> getCategories(Integer id) {
        try {
            Book book = repository.findById(id).get();
            List<CategoryObj> categories = new ArrayList<CategoryObj>();
            book.getCategories()
            .forEach(category ->{
                categories.add(new CategoryObj(category));
                }
            );
            return categories;
        } catch (Exception e) {
            return null;
        }
        
    }

    public Stream<BookObj> getBooksByAuthor(String authorName) {
        try {
            List<BookObj> books = new ArrayList<BookObj>();
            repository.findAll()
            .forEach(book->{
                books.add(new BookObj(book));
            });
            return books.stream().filter(author -> author.getAuthor().equals(authorName));
        } catch (Exception e) {
            return null;
        }
    }

    public Stream<BookObj>  getBooksFromYear(int year) {
        try {
            List<BookObj> books = new ArrayList<BookObj>();
            repository.findAll()
            .forEach(book->{
                books.add(new BookObj(book));
            });
            return books.stream().filter(book -> book.getPublishedDate().endsWith(year+""));
        } catch (Exception e) {
            return null;
        }
    }

    public List<BookObj> getBooksFromCategory(int categoryId) {
        try {
            List<BookObj> books = new ArrayList<BookObj>();
            Category categorySelected = categoryRepository.findById(categoryId).get();
            repository.findAll()
            .forEach(book->{
                if(book.getCategories().contains(categorySelected)){
                    books.add(new BookWithCategories(book));
                }
            });
            return books;
        } catch (Exception e) {
            return null;
        }
    }

    public BookWithCategories getOldestBook() {
        try {
            List<Book> books = new ArrayList<Book>();
            repository.findAll()
            .forEach(book->{
                books.add(book);
            });
            books.stream().sorted(Comparator.comparing(Book::getPublishedDate)).collect(Collectors.toList());
           
            return new BookWithCategories(books.get(0));
        } catch (Exception e) {
            return null;
        }
    }
}
