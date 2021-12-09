package com.sandracoe.booklistapp.Entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table(name = "Book")
public class Book {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
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

    @ManyToMany(mappedBy = "booksLiked", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Users> users =  new ArrayList<Users>();
    
    @ManyToMany
    private List<Category> categories =  new ArrayList<Category>();

    public Book() {
        
    }
   
    public Book(Integer id,String name, String description, String publisher, String author, String isbn,
                String publishedDate) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.publisher = publisher;
        this.author = author;
        this.isbn = isbn;
        this.publishedDate = publishedDate;
    }
    public Book(String name, String description, String publisher, String author, String isbn,
                String publishedDate) {
        this.name = name;
        this.description = description;
        this.publisher = publisher;
        this.author = author;
        this.isbn = isbn;
        this.publishedDate = publishedDate;
    }

    /*public void setCategories(Category categories) {
        this.categories.add(categories);
    }*/
    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }
    public List<Category> getCategories() {
        return categories;
    }
    public void setUsers(List<Users> users) {
        this.users = users;
    }
    public List<Users> getUsers() {
        return users;
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
        if(obj instanceof Book){
            Book book = (Book) obj;
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
