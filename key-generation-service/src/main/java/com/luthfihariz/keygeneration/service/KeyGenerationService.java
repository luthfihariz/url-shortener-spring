package com.luthfihariz.keygeneration.service;


import com.luthfihariz.keygeneration.model.KeyAlias;
import com.luthfihariz.keygeneration.repository.KeyAliasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;

@Service
public class KeyGenerationService {

    @Autowired
    private KeyAliasRepository keyAliasRepository;

    public void generateKey(Integer count) {
        KeyAlias latestId = keyAliasRepository.findLatestId();

        Integer id = 0;
        if (latestId != null) {
            id = latestId.getId();
        }

        id += 13329; // to make sure it's start with 'aaa'

        HashSet<KeyAlias> keySet = new HashSet<>(count);
        while (keySet.size() < count) {
            String key = Integer.toString(++id, 36);
            keySet.add(new KeyAlias(key));
        }

        keyAliasRepository.saveAll(keySet);
    }
}
