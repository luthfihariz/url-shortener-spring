package com.luthfihariz.keygeneration.model;


import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@Getter
public class KeyAlias {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(length = 8, unique = true)
    private String alias;

    public KeyAlias(String alias) {
        this.alias = alias;
    }
}
