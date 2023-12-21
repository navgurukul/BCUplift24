package org.uplift.banking.security;

public class OtpExpiredException extends Exception{

    public OtpExpiredException(String message){
        super(message);
    }

}
