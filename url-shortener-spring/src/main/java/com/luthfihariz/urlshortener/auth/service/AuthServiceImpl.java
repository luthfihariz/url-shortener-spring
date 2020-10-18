package com.luthfihariz.urlshortener.auth.service;

import com.luthfihariz.urlshortener.auth.config.JwtTokenProvider;
import com.luthfihariz.urlshortener.auth.dto.LoginCredentialDto;
import com.luthfihariz.urlshortener.user.dto.SessionDto;
import com.luthfihariz.urlshortener.user.model.User;
import com.luthfihariz.urlshortener.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenProvider jwtToken;


    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(s);
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(),
                new ArrayList<>());
    }

    @Override
    public SessionDto login(LoginCredentialDto loginCredential) throws Exception {
        authenticate(loginCredential.getEmail(), loginCredential.getPassword());
        org.springframework.security.core.userdetails.UserDetails user = loadUserByUsername(loginCredential.getEmail());

        return new SessionDto(jwtToken.generateToken(user.getUsername()));
    }

    private void authenticate(String email, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }
}
