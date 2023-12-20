package org.uplift.account;

import java.util.Date;

public class Transaction {
    private Account sourceAccount;
    private Account targetAccount;
    private Date transactionDate;
    private String id;


    public Transaction(Account sourceAccount, Account targetAccount, Date transactionDate, String id) {
        this.sourceAccount = sourceAccount;
        this.targetAccount = targetAccount;
        this.transactionDate = transactionDate;
        this.id=id;
    }

}
