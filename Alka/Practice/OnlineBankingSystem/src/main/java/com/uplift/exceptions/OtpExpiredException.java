package com.uplift.exceptions;

import com.uplift.bank.security.OtpManager;

public class OtpExpiredException extends Exception{
    public OtpExpiredException(String message){
        super(message);
    }
}
