package org.uplift.account;

public class InsufficientBalance extends Exception {
    InsufficientBalance(String message){
        super(message);
    }
}
