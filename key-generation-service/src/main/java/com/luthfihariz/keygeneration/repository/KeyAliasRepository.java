package com.luthfihariz.keygeneration.repository;

import com.luthfihariz.keygeneration.model.KeyAlias;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface KeyAliasRepository extends JpaRepository<KeyAlias, Integer> {

    @Query(value = "select id, alias from key_alias order by id desc limit 1", nativeQuery = true)
    public KeyAlias findLatestId();

    @Query(value = "select id, alias from key_alias order by id asc limit 1", nativeQuery = true)
    public KeyAlias findTopAlias();
}

