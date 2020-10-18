package com.luthfihariz.urlshortener.user.exception;

import com.luthfihariz.urlshortener.errorhandler.ErrorCode;
import com.luthfihariz.urlshortener.errorhandler.exception.ApplicationException;
import org.springframework.http.HttpStatus;

public class UserNotFoundException extends ApplicationException {

    public UserNotFoundException() {
        super(ErrorCode.ERROR_USER_NOT_FOUND.toString(),
                "Please check your credential", HttpStatus.UNAUTHORIZED);
    }
}
