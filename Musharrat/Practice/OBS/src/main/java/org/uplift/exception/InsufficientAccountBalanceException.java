package org.uplift.account;

public class InsufficientAccountBalanceException extends Exception{
    public InsufficientAccountBalanceException(String message){
        super(message);
    }
}
