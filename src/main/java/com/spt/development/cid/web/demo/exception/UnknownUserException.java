package com.spt.development.cid.web.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Unknown user")
public class UnknownUserException extends Exception {
    public UnknownUserException(long userId) {
        super(String.format("User with ID: %d could not be found", userId));
    }
}
