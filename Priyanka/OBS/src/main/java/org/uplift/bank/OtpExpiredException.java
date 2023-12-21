package org.uplift.bank;

public class OtpExpiredException extends Exception {
    public OtpExpiredException(String message) {
        super(message);
    }
}
