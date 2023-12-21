package org.uplift.Bank.security;

public class OtpExpiredException extends Exception{
    public OtpExpiredException(String message){
        super(message);
    }
}
