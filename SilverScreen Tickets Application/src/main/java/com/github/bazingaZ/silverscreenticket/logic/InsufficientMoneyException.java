package com.github.bazingaZ.silverscreenticket.logic;

public class InsufficientMoneyException extends RuntimeException{

     public InsufficientMoneyException(String message) {
         super(message);
     }

}
