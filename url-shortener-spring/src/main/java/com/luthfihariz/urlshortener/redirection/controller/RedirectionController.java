package com.luthfihariz.urlshortener.redirection.controller;


import com.luthfihariz.urlshortener.redirection.exception.ShortUrlNotFoundException;
import com.luthfihariz.urlshortener.redirection.service.RedirectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class RedirectionController {

    @Autowired
    private RedirectionService redirectionService;

    @GetMapping(path = "/{alias}")
    public ResponseEntity<Void> handleRedirection(@PathVariable("alias") String alias) {
        try {
            String originalUrl = redirectionService.getOriginalUrlFromAlias(alias);
            return ResponseEntity
                    .status(HttpStatus.MOVED_PERMANENTLY)
                    .header(HttpHeaders.LOCATION, originalUrl)
                    .build();

        } catch (NullPointerException npe) {
            throw new ShortUrlNotFoundException();
        }
    }
}
