package com.luthfihariz.urlshortener.repository;

import com.luthfihariz.urlshortener.shortener.model.ShortUrl;

public interface CachedShortUrlRepository {
    public ShortUrl findByAlias(String alias);

    public ShortUrl saveAndCache(ShortUrl shortUrl);
}
