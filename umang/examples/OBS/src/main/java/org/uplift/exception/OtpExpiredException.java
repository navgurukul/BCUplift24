package org.uplift.exception;

import org.uplift.bank.security.OtpManager;

public class OtpExpiredException extends Exception {
    public OtpExpiredException(String message) {
        super(message);
    }
}
