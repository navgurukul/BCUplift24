package org.uplift.account;

import org.uplift.User.User;
import org.uplift.exception.InsufficientBalanceException;

import java.util.Date;

public class SavingAccount implements Account{
    private User user;
    private String accountNumber;
    private double balance;
    private Date openingDate;

    public SavingAccount(User user, String accountNumber, double balance, Date openingDate) {
        this.user = user;
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.openingDate = openingDate;
    }

    @Override
    public double checkBalance() {
        return balance;
    }

    @Override
    public double deposit(double amount) {
        balance+=amount;
        return balance;

    }

    @Override
    public double withdraw(double amount) throws InsufficientBalanceException {
        if(amount>balance) throw new InsufficientBalanceException("amount is higher than your current balance.");
        balance-=amount;
        return balance;
    }

    @Override
    public String toString() {
        return "SavingAccount{" +
                "user=" + user +
                ", accountNumber='" + accountNumber + '\'' +
                ", balance=" + balance +
                ", openingDate=" + openingDate +
                '}';
    }
}
