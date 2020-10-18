package com.luthfihariz.urlshortener.redirection.service;

import com.luthfihariz.urlshortener.shortener.model.ShortUrl;
import com.luthfihariz.urlshortener.shortener.repository.ShortUrlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RedirectionService {

    @Autowired
    private ShortUrlRepository shortUrlRepository;

    public String getOriginalUrlFromAlias(String alias) throws NullPointerException {
        ShortUrl shortUrl = shortUrlRepository.findByAlias(alias);
        return shortUrl.getOriginalUrl();
    }
}
