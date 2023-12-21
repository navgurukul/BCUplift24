package org.uplift.account;

import org.uplift.exception.InsufficientBalanceException;
import org.uplift.user.User;

public interface Account {
    public double deposit(double amount);
    public double withdraw(double amount) throws InsufficientBalanceException;
    public double showBalance();
    public String getAccountNumber();
    public User getUser();

}
