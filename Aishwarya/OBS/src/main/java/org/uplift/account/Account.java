package org.uplift.account;

import org.uplift.user.User;

public interface Account {

    public double showBalance();
    public double deposit(double amount);
    public double withdraw(double amount) throws InsufficientBalanceException;

    public String getAccountNumber();

    public User getUser();
}
