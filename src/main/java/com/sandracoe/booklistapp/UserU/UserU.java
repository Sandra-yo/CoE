package com.sandracoe.booklistapp.UserU;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;

import com.sandracoe.booklistapp.book.Book;

import org.apache.tomcat.jni.User;

public class UserU extends User{
    
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Book>  booksLiked = new ArrayList<Book>();

    public UserU(){
        super();
    }
    public void setBooksLiked(Book booksLiked) {
        this.booksLiked.add(booksLiked);
    }
    
    public List<Book> getBooksLiked() {
        
        return booksLiked;
    }

}
