package com.uplift.account;

import com.uplift.exceptions.InsufficietBalanceException;
import com.uplift.user.User;

import java.util.Date;

public class SavingsAccount implements Account{
    private User user;
    private String accountNumber;

    private double balance;

    private double overdraftLimit;



    private Date openingDate;
    public SavingsAccount(User user, String accountNumber, double balance, Date date, double overdraftLimit) {
        this.user=user;
        this.balance=balance;
        this.openingDate =date;
        this.accountNumber=accountNumber;
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
    public double withdraw(double amount) throws InsufficietBalanceException {
        if(amount>balance+overdraftLimit){
            throw  new InsufficietBalanceException("Sorry! Amount is greater than permissile withdrawal limit ");
        }
        balance-=amount;
        return balance;
    }
}
