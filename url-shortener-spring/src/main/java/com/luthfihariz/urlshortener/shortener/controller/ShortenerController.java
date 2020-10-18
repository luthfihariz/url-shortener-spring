package com.luthfihariz.urlshortener.shortener.controller;

import com.luthfihariz.urlshortener.shortener.dto.ShortenerRequestDto;
import com.luthfihariz.urlshortener.shortener.dto.ShortenerResponseDto;
import com.luthfihariz.urlshortener.shortener.service.ShortenerService;
import com.luthfihariz.urlshortener.user.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("/api/shortener")
public class ShortenerController {

    @Autowired
    private ShortenerService shortenerService;

    @PostMapping("")
    public ShortenerResponseDto shorteningUrl(@RequestBody ShortenerRequestDto shortenerRequestDto, Principal principal) {
        String email = null;
        if (principal != null) {
            email = principal.getName();
        }
        return shortenerService.shorteningUrl(shortenerRequestDto, email);
    }
}
