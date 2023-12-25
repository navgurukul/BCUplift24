package org.uplift.account;

import org.uplift.exceptions.InsufficientBalanceException;
import org.uplift.user.User;

import java.util.Date;

public class SavingsAccount implements Account{
    private User user;
    private String accountNumber;
    private double balance;
    private Date openingDate;
    private double overdraft;
    public SavingsAccount(User user, String accountNumber, double balance, Date openingDate, double overdraft) {
        this.user=user;
        this.accountNumber=accountNumber;
        this.balance=balance;
        this.openingDate=openingDate;

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
    public double withdraw(double amount) {
        if(amount>balance+overdraft){
            throw new InsufficientBalanceException("not sufficient bal");
        }
        balance-=amount;
        return balance;
    }




}
