package com.luthfihariz.urlshortener.shortener.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Getter
@NoArgsConstructor
public class ShortenerRequestDto {
    private String originalUrl;
}
