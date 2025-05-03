package com.github.bazingaZ.silverscreenticket.logic;

public class NoTicketsLeftException extends RuntimeException {

    public NoTicketsLeftException(String message) {
        super(message);
    }
}
