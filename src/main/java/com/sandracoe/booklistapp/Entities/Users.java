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
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "Users")
public class Users {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer user_id;
    private String firstName;
    private String lastName;
    private String country;
    private String registrationDate;
    private String userName;
    private String password;
    private String rol;
    
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Book>  booksLiked = new ArrayList<Book>();

    @JsonIgnore
    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private List<Authority> authorities;

    public Users(){
        
    }
    
    public Users(Integer id, String firstName, String lastName, String country, String registrationDate, String userName,
                 String password){
        this.user_id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.country = country;
        this.registrationDate =registrationDate;
        this.userName = userName;
        this.password  = password;
    }
    public Users( String firstName, String lastName, String country, String registrationDate, String userName,
                 String password){
        this.firstName = firstName;
        this.lastName = lastName;
        this.country = country;
        this.registrationDate =registrationDate;
        this.userName = userName;
        this.password  = password;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
    public String getRol() {
        return rol;
    }
    public void setBooksLiked(Book booksLiked) {
        this.booksLiked.add(booksLiked);
    }
    public List<Authority> getAuthorities() {
        return authorities;
    }
    public void setAuthorities(List<Authority> authority) {
        this.authorities = authority;
    }
    public void setBooksLiked(List<Book> booksLiked) {
        this.booksLiked = booksLiked;
    }

    public List<Book> getBooksLiked() {
        
        return booksLiked;
    }
    
    public Integer getId() {
        return user_id;
    }
    public void setId(Integer id) {
        this.user_id = id;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getRegistrationDate() {
        return registrationDate;
    }
    public void setRegistrationDate(String registrationDate) {
        this.registrationDate = registrationDate;
    }
    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    @Override
    public int hashCode() {
       final int prime = 31;
       int result = 1;
       result = prime * result+((this.user_id == null)?0 : this.user_id.hashCode());
       return result; 
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Users){
            Users user = (Users) obj;
            if(this.user_id == user.user_id){
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        }
    }

    
}
