package org.uplift.account;

import org.uplift.exception.InSufficientBalanceException;

public interface Account {
    public double showBalance();
    public double deposit(double amount);
    public double withdraw(double amount) throws InSufficientBalanceException;
}
