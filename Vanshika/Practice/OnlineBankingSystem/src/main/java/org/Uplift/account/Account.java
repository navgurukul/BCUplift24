package org.Uplift.account;

import org.Uplift.exception.InsufficientBalanceException;

public interface Account {
    public double showBalance();
    public double deposit(double amount);
    public double withdraw(double amount) throws InsufficientBalanceException;
}
