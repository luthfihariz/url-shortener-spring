package com.luthfihariz.urlshortener.user.service;

import com.luthfihariz.urlshortener.user.model.User;
import com.luthfihariz.urlshortener.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import com.luthfihariz.urlshortener.user.exception.UserAlreadyRegisteredException;

@Component
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public User signup(User user) {
        if (userRepository.findByEmail(user.getEmail()) != null) {
            throw new UserAlreadyRegisteredException();
        }

        User encodedUser = new User(user.getEmail(), passwordEncoder.encode(user.getPassword()));
        return userRepository.save(encodedUser);
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
