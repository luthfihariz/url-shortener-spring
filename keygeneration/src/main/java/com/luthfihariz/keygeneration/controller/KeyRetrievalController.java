package com.luthfihariz.keygeneration.controller;


import com.luthfihariz.keygeneration.dto.KeyAliasDto;
import com.luthfihariz.keygeneration.model.KeyAlias;
import com.luthfihariz.keygeneration.service.KeyRetrievalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/retrieval")
public class KeyRetrievalController {

    @Autowired
    private KeyRetrievalService keyRetrievalService;

    @GetMapping("")
    public KeyAliasDto getKeyAlias() {
        KeyAlias availableAlias = keyRetrievalService.getAvailableAlias();
        return new KeyAliasDto(availableAlias.getAlias());
    }
}
