package org.uplift.exceptions;

public class OtpExpiredException extends Exception{
    public OtpExpiredException(String message){
        super(message);
    }
}