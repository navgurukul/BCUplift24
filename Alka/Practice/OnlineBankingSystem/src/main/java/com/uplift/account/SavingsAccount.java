package com.uplift.account;

import com.uplift.exceptions.InsufficietBalanceException;
import com.uplift.user.User;

import java.util.Date;
import java.util.Objects;

public class SavingsAccount implements Account{
    private User user;

    private String accountNumber;

    private double balance;

    private double overdraftLimit;



    private Date openingDate;
    public SavingsAccount(User user, String accountNumber, double balance, Date date, double overdraftLimit) {
        this.user=user;
        this.balance=balance;
        this.openingDate =date;
        this.accountNumber=accountNumber;
        this.overdraftLimit=overdraftLimit;
    }

    public String getAccountNumber() {
        return accountNumber;
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
    public double withdraw(double amount) throws InsufficietBalanceException {
        if(amount>balance+overdraftLimit){
            throw  new InsufficietBalanceException("Sorry! Amount is greater than permissile withdrawal limit ");
        }
        balance-=amount;
        return balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SavingsAccount that = (SavingsAccount) o;
        return Double.compare(balance, that.balance) == 0 && Double.compare(overdraftLimit, that.overdraftLimit) == 0 && Objects.equals(user, that.user) && Objects.equals(accountNumber, that.accountNumber) && Objects.equals(openingDate, that.openingDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user, accountNumber, balance, overdraftLimit, openingDate);
    }


    public  String getPhoneNumber(){
        return user.getMobile();
    }

    public  String getUserName(){
        return user.getUserName();
    }
}
