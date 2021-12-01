package com.sandracoe.booklistapp.users;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Users {
    @Id
    private String id;
    private String firstName;
    private String lastName;
    private String country;
    private String registrationDate;
    private String userName;
    private String password;
    
   // @OneToMany
  //  private Book bookLiked;

    public Users(){
        
    }
    public Users(String id, String firstName, String lastName, String country, String registrationDate, String userName,
                 String password){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.country = country;
        this.registrationDate =registrationDate;
        this.userName = userName;
        this.password  = password;
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
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
    
    
}
