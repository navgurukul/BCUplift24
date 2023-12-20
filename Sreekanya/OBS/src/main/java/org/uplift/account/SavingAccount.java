package org.uplift.account;

import org.uplift.exception.InvalidSufficientBalanceException;
import org.uplift.user.User;

import java.util.Date;

public class SavingAccount implements Account {

    private  User user;
    private  String accountNumber;
    private  double balance;
    private  Date openingDate;
    private  Double overDraft;

    public SavingAccount(User user, String accountNumber, double balance, Date openingDate, Double overDraft) {
        this.user=user;
        this.accountNumber=accountNumber;
        this.balance=balance;
        this.openingDate=openingDate;
        this.overDraft=overDraft;


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
    public double withDraw(double amount) throws InvalidSufficientBalanceException {
        if((balance+overDraft)<amount){
            throw new InvalidSufficientBalanceException("invalid sufficient balance");
        }
        balance-=amount;
        return balance;
    }
}
