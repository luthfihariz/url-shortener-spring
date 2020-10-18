package com.luthfihariz.keygeneration.controller;

import com.luthfihariz.keygeneration.service.KeyGenerationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/generation")
public class KeyGenerationController {

    @Autowired
    private KeyGenerationService keyGenerationService;

    @GetMapping("")
    public ResponseEntity<String> generateKey(@RequestParam Integer count) {
        keyGenerationService.generateKey(count);
        return ResponseEntity.ok("Key generation done");
    }
}
