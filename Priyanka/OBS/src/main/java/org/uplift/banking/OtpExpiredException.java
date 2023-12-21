package org.uplift.banking;

public class OtpExpiredException extends Exception {
    public OtpExpiredException(String message) {
        super(message);
    }
}
