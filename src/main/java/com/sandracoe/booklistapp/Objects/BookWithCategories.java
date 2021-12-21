package com.sandracoe.booklistapp.Objects;

import java.util.ArrayList;
import java.util.List;

import com.sandracoe.booklistapp.Entities.Book;
import com.sandracoe.booklistapp.Entities.Category;

public class BookWithCategories extends BookObj {

    private List<CategoryObj> categories =  new ArrayList<CategoryObj>();
    
    public BookWithCategories(Book book){
        super(book);
       // this.categories = 
        book.getCategories().forEach(category ->{
            this.categories.add(new CategoryObj(category));
        });
    }

    public List<CategoryObj> getCategories() {
        return categories;
    }

    public void setCategories(List<CategoryObj> categories) {
        this.categories = categories;
    }

}
