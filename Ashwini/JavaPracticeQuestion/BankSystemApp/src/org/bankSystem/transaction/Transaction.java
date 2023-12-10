package org.bankSystem.transaction;

import org.bankSystem.ExceptionHandling.InsufficientFundsException;
import org.bankSystem.account.Account;

public class Transaction {
    private Account sourceAccount;
    private Account targetAccount;
    private double amount;

    public Transaction(Account sourceAccount, Account targetAccount, double amount)  {
        this.sourceAccount = sourceAccount;
        this.targetAccount = targetAccount;
        this.amount = amount;
    }

    public void execute() throws InsufficientFundsException{
        sourceAccount.withdrawal(amount);
        targetAccount.deposite(amount);

    }

    public Account getSourceAccount() {
        return sourceAccount;
    }

    public Account getTargetAccount() {
        return targetAccount;
    }

    public double getAmount() {
        return amount;
    }
}
