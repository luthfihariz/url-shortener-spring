package com.luthfihariz.urlshortener.shortener.model;

import com.luthfihariz.urlshortener.user.model.User;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class ShortUrl {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(length = 8, unique = true)
    private String alias;

    @Column(length = 2048)
    private String originalUrl;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public ShortUrl(String alias, String originalUrl) {
        this.alias = alias;
        this.originalUrl = originalUrl;
    }

    public ShortUrl(String alias, String originalUrl, User user) {
        this.alias = alias;
        this.originalUrl = originalUrl;
        this.user = user;
    }
}
