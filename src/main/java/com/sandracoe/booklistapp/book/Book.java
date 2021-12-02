package com.sandracoe.booklistapp.book;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "Book")
public class Book {

    @Id
    @Column(name = "id")
    private String id;
    @Column(name = "bookName")
    private String name;
    @Column(name = "bookDescription")
    private String description;
    @Column(name = "publisher")
    private String publisher;
    @Column(name = "author")
    private String author;
    @Column(name = "isbn")
    private String isbn;
    @Column(name = "publishedDate")
    private String publishedDate;

   // @ManyToMany
    //private Users users;

    public Book() {
        
    }
   
    public Book(String id,String name, String description, String publisher, String author, String isbn,
                String publishedDate) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.publisher = publisher;
        this.author = author;
        this.isbn = isbn;
        this.publishedDate = publishedDate;
    }

    
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getPublisher() {
        return publisher;
    }
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public String getIsbn() {
        return isbn;
    }
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    public String getPublishedDate() {
        return publishedDate;
    }
    public void setPublishedDate(String publishedDate) {
        this.publishedDate = publishedDate;
    }
}
