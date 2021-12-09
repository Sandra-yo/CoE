package com.sandracoe.booklistapp.Entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;



@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String categoryName;

    @ManyToMany(mappedBy = "categories")
    private List<Book> books =  new ArrayList<Book>();
    

    public Category(Integer id, String categoryName) {
        this.id = id;
        this.categoryName = categoryName;
    }
    public Category() {
        
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
    public List<Book> getBooks() {
        return books;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
    public String getCategoryName() {
        return categoryName;
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
        if(obj instanceof Category){
            Category category = (Category) obj;
            if(this.id == category.id){
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        }
    }
}
