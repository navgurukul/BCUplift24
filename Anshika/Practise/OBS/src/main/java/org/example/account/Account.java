package org.example.account;

import org.example.exception.InsufficientAccountBalanceException;
import org.example.user.User;

public interface Account {
    public double showBalance();
    public double deposit(double amount);
    public double withdraw(double amount) throws InsufficientAccountBalanceException;

    public User getUser();
    public String getAccountNo();
}
