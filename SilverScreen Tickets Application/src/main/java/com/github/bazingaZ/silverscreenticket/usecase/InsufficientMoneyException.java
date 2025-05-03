package com.github.bazingaZ.silverscreenticket.usecase;

public class InsufficientMoneyException extends RuntimeException{

     public InsufficientMoneyException(String message) {
         super(message);
     }

}
