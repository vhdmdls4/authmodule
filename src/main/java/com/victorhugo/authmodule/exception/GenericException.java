package com.victorhugo.authmodule.exception;

public class GenericException extends RuntimeException {
    public GenericException(String errorMessage) {
        super(errorMessage);
    }

    public GenericException(String errorMessage, Throwable errorCause) {
        super(errorMessage, errorCause);
    }
}