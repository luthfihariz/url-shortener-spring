package com.luthfihariz.keygeneration.errorhandler;

import org.springframework.http.HttpStatus;

public class KeyAliasUnavailableException extends ApplicationException {


    public KeyAliasUnavailableException() {
        super("KEY_ALIAS_NOT_FOUND", "", HttpStatus.NOT_FOUND);
    }
}
