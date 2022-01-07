package com.sandracoe.booklistapp.Config;

import java.util.List;

import com.sandracoe.booklistapp.Entities.SecurityCustomer;
import com.sandracoe.booklistapp.Entities.Users;
import com.sandracoe.booklistapp.Repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class UserDetailConfig implements UserDetailsService{
    @Autowired
    private UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<Users> users = repository.findByUserName(username);
        if(users.size() == 0){
            throw new UsernameNotFoundException("User not found!");
        }

        return new SecurityCustomer(users.get(0));
    }
    
}
