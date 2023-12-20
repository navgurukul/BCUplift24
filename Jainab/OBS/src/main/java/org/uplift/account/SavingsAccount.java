package org.uplift.account;

import org.uplift.exception.InsufficientBalanceException;
import org.uplift.user.User;

import java.util.Date;

public class SavingsAccount implements Account{

    private User user;
    private String accNumber;
    private double balance;
    private Date openingDate;

    private double overdraftLimit;
    public SavingsAccount(User user, String accNumber, double balance, Date openingDate, double overdraftLimit) {
        this.user=user;
        this.accNumber=accNumber;
        this.balance=balance;
        this.openingDate=openingDate;
        this.overdraftLimit=overdraftLimit;
    }

    @Override
    public double showBalance() {
        return balance;
    }

    @Override
    public double withdraw(double amount) throws InsufficientBalanceException {
        if(amount > balance+overdraftLimit){
            throw new InsufficientBalanceException("Requested amount is greater than balance: "+ amount);

        }
        balance-=amount;
        return balance;
    }
    @Override
    public double deposit(double amount) {
        balance += amount;
        return balance;
    }

}
