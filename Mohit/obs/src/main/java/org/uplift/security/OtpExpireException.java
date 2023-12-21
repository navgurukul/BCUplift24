package org.uplift.security;

public class OtpExpireException extends Exception{
    OtpExpireException(String message){
        super(message);
    }
}
