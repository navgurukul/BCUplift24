package com.uplift.account;

import com.uplift.exceptions.InsufficietBalanceException;

public interface Account {
    public double showBalance();
    public double deposit(double amount);

    public double withdraw(double amount) throws InsufficietBalanceException;


}
