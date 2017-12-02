package com.ysb.j2we.model.exception;

public class PersonNotFoundExceptionControllerSpecific extends RuntimeException {
    public PersonNotFoundExceptionControllerSpecific() {
        super();
    }

    public PersonNotFoundExceptionControllerSpecific(String message) {
        super(message);
    }

    public PersonNotFoundExceptionControllerSpecific(String message, Throwable cause) {
        super(message, cause);
    }

    public PersonNotFoundExceptionControllerSpecific(Throwable cause) {
        super(cause);
    }

    protected PersonNotFoundExceptionControllerSpecific(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
