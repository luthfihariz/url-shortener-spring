package com.luthfihariz.urlshortener.repository;

import com.luthfihariz.urlshortener.shortener.model.ShortUrl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

public class CachedShortUrlRepositoryImpl implements CachedShortUrlRepository {
    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @PersistenceContext
    private EntityManager entityManager;

    private final String TABLE_NAME = "short_url";

    @Override
    public ShortUrl findByAlias(String alias) {
        String originalUrl = redisTemplate.opsForValue().get(alias);

        if (originalUrl == null) {
            String queryString = "select original_url from ? where alias = ?";
            Query query = entityManager.createNativeQuery(queryString);
            query.setParameter(1, TABLE_NAME);
            query.setParameter(2, alias);
        }
        return new ShortUrl(alias, originalUrl);
    }

    @Override
    @Transactional
    public ShortUrl saveAndCache(ShortUrl shortUrl) {
        entityManager.persist(shortUrl);
        redisTemplate.opsForValue().set(shortUrl.getAlias(), shortUrl.getOriginalUrl());
        return shortUrl;
    }
}
