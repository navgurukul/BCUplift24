package org.uplift.uplifte.exceptionhandling;

public class InsufficientBalanceException extends Exception {
    //Insufficient
    public InsufficientBalanceException(String message){
        super(message);
    }
}
