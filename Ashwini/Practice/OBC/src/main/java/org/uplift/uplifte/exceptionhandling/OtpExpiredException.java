package org.uplift.uplifte.exceptionhandling;

public class OtpExpiredException extends Exception {
    public OtpExpiredException(String message){
        super(message);
    }
}
