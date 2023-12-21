package org.uplift.bank;

public class OtpExpiredException extends Exception{
    OtpExpiredException(String message){
        super(message);
    }
}
