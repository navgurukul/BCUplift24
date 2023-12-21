package org.Uplift.exception;

import org.Uplift.Bank.security.OtpManager;

public class OtpExpiredException extends Exception{
    public OtpExpiredException(String message){
        super(message);
    }
}
