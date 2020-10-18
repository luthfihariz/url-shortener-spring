package com.luthfihariz.keygeneration.service;


import com.luthfihariz.keygeneration.errorhandler.KeyAliasUnavailableException;
import com.luthfihariz.keygeneration.model.KeyAlias;
import com.luthfihariz.keygeneration.repository.KeyAliasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KeyRetrievalService {

    @Autowired
    private KeyAliasRepository keyAliasRepository;

    public KeyAlias getAvailableAlias() {
        KeyAlias keyAlias = keyAliasRepository.findTopAlias();

        if (keyAlias == null) {
            throw new KeyAliasUnavailableException();
        }
        keyAliasRepository.deleteById(keyAlias.getId());
        return keyAlias;
    }
}
