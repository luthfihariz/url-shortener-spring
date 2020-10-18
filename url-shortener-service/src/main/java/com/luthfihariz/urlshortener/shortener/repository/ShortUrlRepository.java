package com.luthfihariz.urlshortener.shortener.repository;

import com.luthfihariz.urlshortener.shortener.model.ShortUrl;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShortUrlRepository extends JpaRepository<ShortUrl, Integer> {
    public ShortUrl findByAlias(String alias);
}
