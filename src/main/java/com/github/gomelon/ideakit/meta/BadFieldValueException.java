package com.github.gomelon.ideakit.meta;

public class BadFieldValueException extends RuntimeException {

    public BadFieldValueException(String message) {
        super(message);
    }

    public BadFieldValueException(Throwable throwable) {
        super(throwable);
    }
}
