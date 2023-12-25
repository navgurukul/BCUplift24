package org.uplift.account;

import org.uplift.exceptions.InsuffucentBalanceException;
import org.uplift.user.User;

import java.util.Date;

public class Saving implements Account{
    private  double overdraftLimit;
    private Date openingDate;
    private  double balance;
    private String accountNumber;
    private User user;


    public Saving(User user, String accountNumber, double balace, Date openingDate, double overdraftLimit) {
        this.accountNumber=accountNumber;
        this.balance=balace;
        this.openingDate = openingDate;
        this.overdraftLimit=overdraftLimit;
        this.user=user;
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
    public double withdraw(double amount) throws InsuffucentBalanceException {
        if(amount>balance+overdraftLimit) {
            throw new InsuffucentBalanceException("Sorry");
        }
        balance-=amount;
        return balance;
    }

    public Date getOpeningDate() {
        return openingDate;
    }

    public double getBalance() {
        return balance;
    }


    public double getOverdraftLimit() {
        return overdraftLimit;
    }
    public String getUserName(){
        return user.getUserName();
    }
    public String getMobileNumber(){
        return  user.getPhone();
    }
    public String getAccountNumber(){
        return  accountNumber;
    }
    public User getUser(){
        return user;
    }
}
