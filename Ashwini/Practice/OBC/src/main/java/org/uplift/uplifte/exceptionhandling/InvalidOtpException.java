package org.uplift.uplifte.exceptionhandling;

public class InvalidOtpException extends Exception{
    public InvalidOtpException(String message){
        super(message);
    }
}
