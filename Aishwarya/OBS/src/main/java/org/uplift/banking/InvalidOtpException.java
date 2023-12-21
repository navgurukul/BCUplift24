package org.uplift.banking;

public class InvalidOtpException extends Throwable {
    public InvalidOtpException(String message) {
        super(message);
    }
}
