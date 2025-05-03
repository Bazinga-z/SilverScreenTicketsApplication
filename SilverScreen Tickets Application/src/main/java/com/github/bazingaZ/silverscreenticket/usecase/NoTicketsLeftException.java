package com.github.bazingaZ.silverscreenticket.usecase;

public class NoTicketsLeftException extends RuntimeException {

    public NoTicketsLeftException(String message) {
        super(message);
    }
}
