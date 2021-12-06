package com.sandracoe.booklistapp.Objects;

import com.sandracoe.booklistapp.Entities.Category;

public class CategoryObj {
    private Integer id;
    private String categoryName;

    public CategoryObj(Category category) {
        this.id = category.getId();
        this.categoryName = category.getCategoryName();
    }
    public CategoryObj(Integer id, String categoryName) {
        this.id = id;
        this.categoryName = categoryName;
    }
    public CategoryObj() {
        
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
        if(obj instanceof CategoryObj){
            CategoryObj user = (CategoryObj) obj;
            if(this.id == user.id){
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        }
    }   
}
