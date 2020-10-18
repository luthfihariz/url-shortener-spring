package com.luthfihariz.urlshortener.user.exception;

import com.luthfihariz.urlshortener.errorhandler.exception.ApplicationException;
import com.luthfihariz.urlshortener.errorhandler.ErrorCode;
import org.springframework.http.HttpStatus;

public class UserAlreadyRegisteredException extends ApplicationException {

    public UserAlreadyRegisteredException() {
        super(ErrorCode.ERROR_USER_ALREADY_REGISTERED.toString(),
                "User already registered",
                HttpStatus.BAD_REQUEST);
    }
}
