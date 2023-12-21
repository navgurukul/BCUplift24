package org.example.account;

import org.example.exception.InsufficientBalanceException;
import org.example.user.User;

public interface Account {
    public double showBalance();
    public double deposit(double amount);
    public double withdraw(double amount) throws InsufficientBalanceException;

    public String getAccountNumber();
    public User getUser();
}
