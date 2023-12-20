package org.uplift.account;

import org.uplift.exception.InsufficientBalanceException;
import org.uplift.user.User;

import java.util.Date;

public class SavingsAccount implements  Account{

    private User user;
    private String accountNumber;
    private double balance;
    private Date openDate;
    private double overdraftLimit;


    public SavingsAccount(User user, String accountNumber, double balance, Date openDate, double overdraftLimit) {
        this.user=user;
        this.accountNumber=accountNumber;
        this.balance=balance;
        this.openDate=openDate;
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
        if(amount>balance+overdraftLimit){
            throw new InsufficientBalanceException("Balance is not sufficient for Withdraw");
        }
        balance -=amount;
        return balance;
    }

    public double getOverdraftLimit() {
        return overdraftLimit;
    }
}
