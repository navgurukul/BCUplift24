package org.uplift.bank;

public class OTPExpiredException extends Exception {
    public OTPExpiredException(String massege){
        super(massege);
    }
}
