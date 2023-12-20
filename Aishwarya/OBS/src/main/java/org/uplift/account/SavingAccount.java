package org.uplift.account;

import org.uplift.user.User;

import java.util.Date;

public class SavingAccount implements Account {
    private User user;
    private String accountnumber;
    private double balance;
    private Date openingDate;
    private double overdraftLimit;

    public SavingAccount(User user, String accountNumber, double balance, Date openingDate, double overdraftLimit) {
        this.user = user;
        this.accountnumber = accountNumber;
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
        balance = balance + amount;
        return balance;
    }

    @Override
    public double withdraw(double amount) throws InsufficientBalanceException {
        if (amount > balance + overdraftLimit){
            throw new InsufficientBalanceException("Requested amount is greater then permissible amount " + balance + overdraftLimit);
        }
        balance = balance - amount;
        return balance;
    }
}
