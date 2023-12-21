package org.uplift.account;

import org.uplift.account.exception.InsufficientBalanceException;
import org.uplift.account.user.User;

public interface Account {
    public double showBalance();
    public double deposit(double amount);
    public double withdraw(double amount) throws InsufficientBalanceException;
    public String getAccountNumber();
    public User getUser();
}
