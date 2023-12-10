package org.bankSystem.account;

import org.bankSystem.ExceptionHandling.InsufficientFundsException;

public class Account {
    private String accountNumber;
    private double balance;
    public  Account(String accountNumber){
        this.accountNumber = accountNumber;
        this.balance = 0.0;

    }
    public  void deposite(double amount){
        balance+=amount;
    }

    public double withdrawal(double amount) throws InsufficientFundsException {
        if (amount > balance){
            throw new InsufficientFundsException("Insufficient funds in the account");
        }
        balance -=amount;
        return amount;
    }


    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void feeDeduction(){
        balance -= 5;
        System.out.println("Fee has been deducted");
    }
}
