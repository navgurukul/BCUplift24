package org.uplift.exceptions;

public class OTPExpiredException extends Exception {
    public OTPExpiredException(String massege){
        super(massege);
    }
}
