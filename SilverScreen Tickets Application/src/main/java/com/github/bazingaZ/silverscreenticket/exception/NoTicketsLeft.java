package com.github.bazingaZ.silverscreenticket.exception;

public class NoTicketsLeft extends RuntimeException {

    public NoTicketsLeft(String message) {
        super(message);
    }
}
