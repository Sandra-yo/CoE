package com.sandracoe.booklistapp.Objects;

import com.sandracoe.booklistapp.Entities.Book;

public class BookObj {
    
    private Integer id;
    private String name;
    private String description;
    private String publisher;
    private String author;
    private String isbn;
    private String publishedDate;
    private String bookCover;


    public BookObj() {
        
    }
   
    public String getBookCover() {
        return bookCover;
    }

    public void setBookCover(String bookCover) {
        this.bookCover = bookCover;
    }

    public BookObj(Book book) {
        this.id = book.getId();
        this.name = book.getName();
        this.description = book.getDescription();
        this.publisher = book.getPublisher();
        this.author = book.getAuthor();
        this.isbn = book.getIsbn();
        this.publishedDate = book.getPublishedDate();
        this.bookCover = book.getBookCover();
    }
    public BookObj(Integer id,String name, String description, String publisher, String author, String isbn,
                String publishedDate) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.publisher = publisher;
        this.author = author;
        this.isbn = isbn;
        this.publishedDate = publishedDate;
    }
    public BookObj(String name, String description, String publisher, String author, String isbn,
            String publishedDate) {
        
        this.name = name;
        this.description = description;
        this.publisher = publisher;
        this.author = author;
        this.isbn = isbn;
        this.publishedDate = publishedDate;
        }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
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
    @Override
    public int hashCode() {
       final int prime = 31;
       int result = 1;
       result = prime * result+((this.id == null)?0 : this.id.hashCode());
       return result; 
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof BookObj){
            BookObj book = (BookObj) obj;
            if(this.id == book.id){
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        }
    }
}
