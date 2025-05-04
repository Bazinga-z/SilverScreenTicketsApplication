package com.github.bazingaZ.silverscreenticket.exception;

public class InsufficientTicket extends RuntimeException{
    public InsufficientTicket(String message) {
        super(message);
    }
}
