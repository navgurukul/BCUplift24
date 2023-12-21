package org.uplift.account;

import javafx.beans.value.ObservableBooleanValue;
import org.uplift.exception.InSufficientBalanceException;
import org.uplift.user.User;

import java.util.Date;

public class SavingAccount implements Account{
    private User user;
    private double balance;
    private String accountNumber;
    private Date date;
    private double overoverDraftLimit;

    public SavingAccount(User user, double balance, String accountNumber, Date date, double overDraftLimit) {
        this.user = user;
        this.balance = balance;
        this.accountNumber = accountNumber;
        this.date = date;
        this.overoverDraftLimit=overDraftLimit;
    }

    @Override
    public double showBalance() {
        return balance;
    }

    @Override
    public double deposite(double amount) {
        balance+=amount;
        return balance;
    }

    @Override
    public double withdraw(double amount) throws InSufficientBalanceException {
        if(amount>balance+overoverDraftLimit) {
            throw new InSufficientBalanceException("Balance is not available");
        }
        balance -= amount;
        return balance;
    }

//    @Override
//    public String findAccountNumber() {
//
//    }

    public String getAccountNumber() {
        return accountNumber;
    }
    public User getUser(){
        return user;
    }
}
