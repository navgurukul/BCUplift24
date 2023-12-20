package org.uplift.account;

public class InsufficientBalanceException extends Throwable {
    public InsufficientBalanceException(String message) {
        super(message);
    }
}
