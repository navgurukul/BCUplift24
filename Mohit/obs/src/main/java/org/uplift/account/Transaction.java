package org.uplift.account;

import javax.xml.crypto.Data;

public class Transaction {
    private Account sourceAccount;
    private Account targetaccount;
    private Data transactionData;
    private double amount;
    private String id;
    public Transaction(Account sourceAccount, Account targetaccount, Data transactionData, double amount, String id) {
        this.sourceAccount = sourceAccount;
        this.targetaccount = targetaccount;
        this.transactionData = transactionData;
        this.amount = amount;
        this.id = id;
    }



}
