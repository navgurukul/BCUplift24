package org.uplift.account;

import org.uplift.exception.InSufficientBalanceException;
import org.uplift.user.User;

import java.util.Date;

public class SavingAccount implements Account {
    private User user;
    private String accountNumber;
    private double balance;
    private Date openingDate;
    private double overdraftLimit;
    public SavingAccount(User user, String accountNumber, double balance, Date openingDate, double overdraftLimit) {
        this.user = user;
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.openingDate = openingDate;
        this.overdraftLimit = overdraftLimit;


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
    public double withdraw(double amount) throws InSufficientBalanceException {
        if(amount > balance + overdraftLimit){
            throw new InSufficientBalanceException("Requested amount is greater than permissible amount" + (overdraftLimit+balance));
        }
        balance-=amount;
        return balance;
    }

    public User getUser() {
        return user;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public Date getOpeningDate() {
        return openingDate;
    }

    public double getOverdraftLimit() {
        return overdraftLimit;
    }

}
