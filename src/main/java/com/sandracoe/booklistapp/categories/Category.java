package com.sandracoe.booklistapp.categories;

import javax.persistence.Entity;
import javax.persistence.Id;



@Entity
public class Category {
    @Id
    private String id;
    private String categoryName;

    //@ManyToMany
   // private Book books;
    

    public Category(String id, String categoryName) {
        this.id = id;
        this.categoryName = categoryName;
    }
    public Category() {
        
    }
    
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
    public String getCategoryName() {
        return categoryName;
    }
}
