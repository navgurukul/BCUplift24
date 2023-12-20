package org.example.account;

public class InsufficientBalanceException extends Exception {
    InsufficientBalanceException(String message){
        super(message);
    }
}
