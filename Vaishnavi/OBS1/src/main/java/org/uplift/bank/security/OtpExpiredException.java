package org.uplift.bank.security;

public class OtpExpiredException extends Throwable {
    public OtpExpiredException(String message) {
        super(message);
    }
}
