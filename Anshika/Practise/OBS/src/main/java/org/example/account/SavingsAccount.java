package org.example.account;

import org.example.exception.InsufficientAccountBalanceException;
import org.example.user.User;

import java.util.Date;

public class SavingsAccount implements Account {
    private User user;
    private String accountNumber;
    private double balance;
    private Date openingDate;
    private double overdraftLimit;
    public SavingsAccount(User user, String accountNumber, double balance,
                          Date openingDate, double overdraftLimit) {
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
        this.balance += amount;
        return balance;
    }

    @Override
    public double withdraw(double amount) throws InsufficientAccountBalanceException {
        if (amount > balance+overdraftLimit){
            throw new InsufficientAccountBalanceException("Requested amount is greater" +
                    "than permissible withdrawal limit of "+balance+overdraftLimit);
        }
        this.balance -= amount;
        return balance;
    }

    @Override
    public User getUser() {
        return user;
    }

    @Override
    public String getAccountNo() {
        return accountNumber;
    }
}
