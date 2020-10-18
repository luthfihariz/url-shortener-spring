package com.luthfihariz.urlshortener.user.model;

import com.luthfihariz.urlshortener.shortener.model.ShortUrl;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity
public class User {
    @Id
    @GeneratedValue
    private Integer id;

    private String email;
    private String password;

    @OneToMany(mappedBy = "user")
    private Set<ShortUrl> shortUrls;

    public User() {
    }

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public User(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
