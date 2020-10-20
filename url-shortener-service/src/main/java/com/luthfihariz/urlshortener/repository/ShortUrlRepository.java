package com.luthfihariz.urlshortener.repository;

import com.luthfihariz.urlshortener.shortener.model.ShortUrl;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShortUrlRepository extends JpaRepository<ShortUrl, Integer>, CachedShortUrlRepository {
    public ShortUrl findByAlias(String alias);
}
