package org.example.exception;

public class OTPExpiredException extends Exception{
    public OTPExpiredException(String message){
        super(message);
    }

}
