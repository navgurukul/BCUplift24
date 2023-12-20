package org.uplift.account;

import org.uplift.uplifte.exceptionhandling.InsufficientBalanceException;

public interface Account {
    public double showBalance();
    public double deposit(double amount);
    public double withdraw(double amount) throws InsufficientBalanceException;
}
