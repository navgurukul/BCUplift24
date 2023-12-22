package org.example.exception;

public class OtpExpiredException extends Exception {

    public OtpExpiredException(String message){
        super(message);
    }
}
