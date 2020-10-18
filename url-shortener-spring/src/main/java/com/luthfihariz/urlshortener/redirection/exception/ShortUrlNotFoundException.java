package com.luthfihariz.urlshortener.redirection.exception;

import com.luthfihariz.urlshortener.errorhandler.ErrorCode;
import com.luthfihariz.urlshortener.errorhandler.exception.ApplicationException;
import org.springframework.http.HttpStatus;

public class ShortUrlNotFoundException extends ApplicationException {

    public ShortUrlNotFoundException() {
        super(ErrorCode.ERROR_SHORT_URL_NOT_FOUND.toString(), "Not found", HttpStatus.NOT_FOUND);
    }
}
