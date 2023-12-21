package org.uplift.account;

import org.uplift.User.User;
import org.uplift.exception.InsufficientBalanceException;

public interface Account {
    User getUser();
    String getAccountNumber();
    double checkBalance();
    double deposit(double amount);
    double withdraw(double amount) throws InsufficientBalanceException;

}
