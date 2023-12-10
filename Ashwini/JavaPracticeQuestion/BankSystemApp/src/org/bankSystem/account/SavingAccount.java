package org.bankSystem.account;

public class SavingAccount extends Account {
    private double interestRate;

    public SavingAccount(String accountNumber, double interestRate){
        super(accountNumber);
        this.interestRate= interestRate;
    }

    public double calculateInterest(){
        return getBalance()*interestRate;
    }




}
