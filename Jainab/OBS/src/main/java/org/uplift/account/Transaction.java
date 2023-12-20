package org.uplift.account;

import java.util.Date;

public class Transaction {
    private Account sourceAccount;
    private Account targetAccount;
    private Date transaction;
    private double amount;
    private String id;

    public Transaction(Account sourceAccount, Account targetAccount, Date transaction, double amount, String id) {
        this.sourceAccount = sourceAccount;
        this.targetAccount = targetAccount;
        this.transaction = transaction;
        this.amount = amount;
        this.id = id;
    }


}
