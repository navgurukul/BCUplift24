package org.uplift.account;

import org.uplift.account.exception.InsufficientBalanceException;
import org.uplift.account.user.User;

import java.util.Date;

public class SavingAccount implements Account {

    private User user;
    private String accountNumber;
    private double balance;
    private Date openingDate;
    private double overdraftLimit;

    public SavingAccount(User user, String accountNumber, double balance, Date openingDate, double overdraftLimit) {
        this.user = user;
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.openingDate = openingDate;
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public double showBalance() {
        return balance;
    }

    @Override
    public double deposit(double amount) {
        balance += amount;
        return balance;
    }

    @Override
    public double withdraw(double amount) throws InsufficientBalanceException {
        if (amount>balance+overdraftLimit) {
            throw new InsufficientBalanceException("Insufficient balance Exception");
        }
        balance -= amount;
        return balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public User getUser() {
        return user;
    }
}
