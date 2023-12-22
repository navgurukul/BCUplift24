package org.example.exception;

public class InsufficientAccountBalanceException extends Exception{
    public InsufficientAccountBalanceException(String message){
        super(message);
    }
}
