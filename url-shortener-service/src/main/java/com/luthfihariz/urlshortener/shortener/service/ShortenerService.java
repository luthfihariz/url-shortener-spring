package com.luthfihariz.urlshortener.shortener.service;

import com.luthfihariz.urlshortener.shortener.dto.ShortenerRequestDto;
import com.luthfihariz.urlshortener.shortener.dto.ShortenerResponseDto;
import com.luthfihariz.urlshortener.user.model.User;

public interface ShortenerService {

    public ShortenerResponseDto shorteningUrl(ShortenerRequestDto requestDto, String email);
}
