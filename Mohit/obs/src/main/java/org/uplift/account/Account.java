package org.uplift.account;

import org.uplift.exception.InSufficientBalanceException;

public interface Account {
    public double showBalance();
    public double deposite(double amount);
    public double withdraw(double amount) throws InSufficientBalanceException;
}
