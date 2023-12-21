package org.uplift.security;

public class OtpExpiredException extends Exception {
    public  OtpExpiredException (String message){
        super(message);
    }
}
