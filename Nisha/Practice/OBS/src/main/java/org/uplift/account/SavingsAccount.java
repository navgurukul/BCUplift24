package org.uplift.account;

import org.uplift.Exceptions.InsufficientBalanceException;
import org.uplift.user.User;

import java.util.Date;

public class SavingsAccount implements Account{
    private double balance;
    private String accountNumber;

    private User user;
    private Date openingDate;
    private double overDraftLimit;

    public SavingsAccount(User user, double balance, String accountNumber, Date openingDate, double overDraftLimit) {
        this.balance = balance;
        this.accountNumber = accountNumber;
        this.user = user;
        this.openingDate = openingDate;
        this.overDraftLimit=overDraftLimit;
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
        if(amount>balance+overDraftLimit) throw new InsufficientBalanceException("Requested amount is greater than the amount in the bank , balance should be less than the "+balance+overDraftLimit);
        else{
            balance-=amount;}
        return balance;
    }
}
