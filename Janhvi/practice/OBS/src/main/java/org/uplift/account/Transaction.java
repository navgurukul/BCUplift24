package org.uplift.account;

import java.util.Date;

public class Transaction {
    private Account sourceAccount;
    private Account targetAccount;
    private Date transactionDate;
    private double amount;
    private String transactionId;

    public Transaction(Account sourceAccount, Account targetAccount, Date transactionDate, double amount, String transactionId) {
        this.sourceAccount = sourceAccount;
        this.targetAccount = targetAccount;
        this.transactionDate = transactionDate;
        this.amount = amount;
        this.transactionId = transactionId;
    }
}
