package org.uplift.exception;

public class InsufficientAccountBalanceException extends Exception{
    public InsufficientAccountBalanceException(String message){
        super(message);
    }
}
