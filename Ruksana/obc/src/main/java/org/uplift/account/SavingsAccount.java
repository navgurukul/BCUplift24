package org.uplift.account;

import org.uplift.exception.InvalidSufficientBalanceException;
import org.uplift.user.User;

import java.util.Date;

public class SavingsAccount implements  Account{

    private User user;
    private  String accountNumber;
    private Double balance;
    private Date openingDate;
    private double overdraftLimit;

    public SavingsAccount(User user, String accountNumber, Double balance, Date openingDate,double overdraftLimit) {
        this.user=user;
        this.accountNumber=accountNumber;
        this.balance=balance;
        this.openingDate=openingDate;
        this.overdraftLimit=overdraftLimit;

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
    public Double withDraw(double amount) throws InvalidSufficientBalanceException {
        if (amount>balance+overdraftLimit) {
            throw new InvalidSufficientBalanceException("Insufficient balance");
        }
        balance -= amount;
        return balance;

        //return false;
    }
}
