package org.uplift.account;

import org.uplift.exception.InvalidSufficientBalanceException;

public interface Account {
    public double showBalance();
    public double deposit(double amount);
    public Double withDraw(double amount) throws InvalidSufficientBalanceException;


}
