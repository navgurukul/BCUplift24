package org.uplift.account;

import org.uplift.exception.InsufficientBalanceException;
import org.uplift.user.User;

import java.util.Date;

public class SavingsAccount implements Account{
    private  User user;
    private  String accountNumber;
    private double balance;
    private Date openingDate;
    private double overdraftLimit;

//    private Bank bank;

    public SavingsAccount(User user, String accountNumber, double balance, Date openingDate, double overdraftLimit) {
        this.user=user;
        this.accountNumber=accountNumber;
        this.balance=balance;
        this.openingDate=openingDate;
        this.overdraftLimit=overdraftLimit;
    }

    @Override
    public double deposit(double amount) {
        balance+=amount;
        return balance;
    }

    @Override
    public double withdraw(double amount) throws InsufficientBalanceException {
        if(amount>balance+overdraftLimit) throw new InsufficientBalanceException("Insufficient Balance");
        balance -= amount;
        return balance;
    }

    @Override
    public double showBalance() {
        return balance;
    }

    @Override
    public String getAccountNumber() {
        return accountNumber;
    }

    @Override
    public User getUser() {
        return user;
    }
}
