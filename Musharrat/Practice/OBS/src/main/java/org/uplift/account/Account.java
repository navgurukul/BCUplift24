package org.uplift.account;

import org.uplift.exception.InsufficientAccountBalanceException;

public interface Account {
    public double showBalance();
    public double deposit(double amount);
    public double withdraw(double amount) throws InsufficientAccountBalanceException;
}
