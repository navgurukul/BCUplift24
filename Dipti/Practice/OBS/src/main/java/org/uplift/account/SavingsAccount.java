package org.uplift.account;

import org.uplift.user.User;

import java.util.Date;

//after writiing implemeting method make test and go to add dependancy
public class SavingsAccount implements Account{

    private double overdraftLimit;
    private User user;

private String acountNumber;
private double balance;
private Date openingDate;

    public SavingsAccount(User user, String acountNumber, double balance, Date openingDate,double overdraftLimit) {
        this.user=user;
        this.acountNumber=acountNumber;
        this.balance=balance;
        this.openingDate=openingDate;
        this.overdraftLimit=overdraftLimit;

    }

    public double getOverdraftLimit() {
        return overdraftLimit;
    }

    public User getUser() {
        return user;
    }

    public String getAcountNumber() {
        return acountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public Date getOpeningDate() {
        return openingDate;
    }

    @Override
    public double showBalance() {
        return balance;
    }

    @Override
    public double deposit(double amount) {
        balance =balance +amount;
        return balance;
    }


    @Override
    public double withdraw(double amount)throws InsufficientBalanceException {
      if(amount>balance+overdraftLimit){
          throw new InsufficientBalanceException("balance is greater than the permissible limit" + balance +overdraftLimit) ;
      }
      balance= balance-amount;
      return balance;
    }
}
