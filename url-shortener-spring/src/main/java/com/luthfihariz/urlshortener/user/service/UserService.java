package com.luthfihariz.urlshortener.user.service;


import com.luthfihariz.urlshortener.user.model.User;
import org.springframework.stereotype.Component;

@Component
public interface UserService {
    public User signup(User user);

    public User findByEmail(String email);
}
