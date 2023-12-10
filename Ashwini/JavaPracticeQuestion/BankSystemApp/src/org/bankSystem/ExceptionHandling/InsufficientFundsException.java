package org.bankSystem.ExceptionHandling;

public class InsufficientFundsException extends  Exception{
    public InsufficientFundsException(String message){
        super(message);
    }
}
