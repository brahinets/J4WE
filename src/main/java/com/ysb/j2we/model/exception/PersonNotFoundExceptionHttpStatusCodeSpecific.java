package com.ysb.j2we.model.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "No such Person")
public class PersonNotFoundExceptionHttpStatusCodeSpecific extends RuntimeException {
    public PersonNotFoundExceptionHttpStatusCodeSpecific() {
        super();
    }

    public PersonNotFoundExceptionHttpStatusCodeSpecific(String message) {
        super(message);
    }

    public PersonNotFoundExceptionHttpStatusCodeSpecific(String message, Throwable cause) {
        super(message, cause);
    }

    public PersonNotFoundExceptionHttpStatusCodeSpecific(Throwable cause) {
        super(cause);
    }

    protected PersonNotFoundExceptionHttpStatusCodeSpecific(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
