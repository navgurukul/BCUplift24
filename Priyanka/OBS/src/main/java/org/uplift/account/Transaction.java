package org.uplift.account;

import java.util.Date;

public class Transaction {
    private Account savingAccount;
    private Account targetAccount;
    private Date transactionDate;
    private double amount;
    private String id;

    public Transaction(Account savingAccount, Account targetAccount, Date transactionDate, double amount, String id) {
        this.savingAccount = savingAccount;
        this.targetAccount = targetAccount;
        this.transactionDate = transactionDate;
        this.amount = amount;
        this.id = id;
    }
}
