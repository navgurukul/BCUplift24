package org.bankSystem.account;

import org.bankSystem.ExceptionHandling.InsufficientFundsException;

public class CheckingAccount extends  Account {
    private double overdraft;

    public CheckingAccount(String accountNumber, double overdraft) {
        super(accountNumber);
        this.overdraft = overdraft;
    }


    public double withdrawal(double amount) throws InsufficientFundsException {
        double v = 0;
        if (amount > (getBalance() + overdraft)) {
            throw new InsufficientFundsException("Withdrawal amount exceeds overdraft limit");
        } else if (amount > getBalance()) {
            v = (getBalance() + overdraft) - amount;
           super.setBalance(0);
            return 0;
        }
         return  super.withdrawal(amount);

    }

}
