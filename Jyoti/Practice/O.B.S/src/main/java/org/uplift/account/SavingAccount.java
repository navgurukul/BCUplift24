package org.uplift.account;

import org.uplift.account.Account;
import org.uplift.exception.InsufficientBalanceException;
import org.uplift.user.User;

import java.util.Date;

public class SavingAccount implements Account {
    private String accountNumber;
    private String name;
    private double balance;
    private Date openingDate;
    private User user;
    private double overdraftLimit;

    public SavingAccount(String accountNumber, String name, double balance, Date openingDate, User user, double overdraftLimit) {
        this.accountNumber = accountNumber;
        this.name = name;
        this.balance = balance;
        this.openingDate = openingDate;
        this.user = user;
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public double showBalance() {
        return balance;
    }

    @Override
    public double deposit(double amount) {
        return balance +=amount;
    }

    @Override
    public double withdraw(double amount) throws InsufficientBalanceException {
        if (amount >balance + overdraftLimit){
            throw new InsufficientBalanceException("sorry balance is not sufficient " + balance+overdraftLimit);
        }
        return balance -= amount;

    }
}