package org.uplift.account;

public interface Account {
    public double showBalance();
    public boolean deposit(double amount);
    public boolean withdraw(double amount);
}
