package com.luthfihariz.urlshortener.shortener.exception;

import com.luthfihariz.urlshortener.errorhandler.ErrorCode;
import com.luthfihariz.urlshortener.errorhandler.exception.ApplicationException;
import org.springframework.http.HttpStatus;

public class KeyAliasRetrievalFailedException extends ApplicationException {


    public KeyAliasRetrievalFailedException() {
        super(ErrorCode.KGS_FAILURE.toString(), "KGS FAILURE", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
