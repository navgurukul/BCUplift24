package org.uplift.account;

import org.uplift.exception.InsufficientBalanceException;

public interface Account {
    double checkBalance();
    double deposit(double amount);
    double withdraw(double amount) throws InsufficientBalanceException;
}
