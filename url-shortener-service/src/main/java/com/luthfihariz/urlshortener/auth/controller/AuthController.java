package com.luthfihariz.urlshortener.auth.controller;

import com.luthfihariz.urlshortener.auth.dto.LoginCredentialDto;
import com.luthfihariz.urlshortener.auth.service.AuthService;
import com.luthfihariz.urlshortener.user.dto.SessionDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/")
    public SessionDto login(@RequestBody LoginCredentialDto loginCredential) throws Exception {
        return authService.login(loginCredential);
    }

}