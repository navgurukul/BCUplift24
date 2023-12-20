package org.Uplift.account;

import org.Uplift.exception.InsufficientBalanceException;
import org.Uplift.user.User;

import java.util.Date;

public class SavingsAccount implements Account{

    private User user;
    private String accountNumber;
    private double balance;
    private Date date;
    private double overDraftLimit;

    public SavingsAccount(User user, String accountNumber, double balance, Date date, double overDraftLimit) {
        this.user= user;
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.date = date;
        this.overDraftLimit = overDraftLimit;
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
        if (amount> balance + overDraftLimit){
            throw new InsufficientBalanceException("Amount withdrawn is greater than limit");
        }
        balance-=amount;
        return balance;
    }
}
