package org.example.account;

import org.example.exception.InsufficientBalanceException;
import org.example.user.User;

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
        this.overdraftLimit=overdraftLimit;
    }

    @Override
    public double showBalance() {
        return balance;
    }

    @Override
    public double deposit(double amount) {
        balance+=amount;
        return balance;
    }

    @Override
    public double withdraw(double amount) throws InsufficientBalanceException {
        if(balance+overdraftLimit<amount){
            throw new InsufficientBalanceException("Request amount is greater than permissible amount"+(overdraftLimit+balance));
        }
        balance-=amount;
        return balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    @Override
    public User getUser() {
        return user;
    }
}
