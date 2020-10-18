package com.luthfihariz.urlshortener.auth.service;

import com.luthfihariz.urlshortener.auth.dto.LoginCredentialDto;
import com.luthfihariz.urlshortener.user.dto.SessionDto;
import com.luthfihariz.urlshortener.user.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface AuthService extends UserDetailsService {
    public SessionDto login(LoginCredentialDto loginCredential) throws Exception;
}
