package org.uplift.account;

import java.util.Date;

public class Transaction {
    private Account sourceAccount;
    private Account targetAccount;
    private Date transactionDate;
    private String id;

    public Transaction(Account sourceAccount, Account targetAccount, Date transactionDate,String id) {
        this.sourceAccount = sourceAccount;
        this.targetAccount = targetAccount;
        this.transactionDate = transactionDate;
        this.id=id;
    }

    public Account getSourceAccount() {
        return sourceAccount;
    }

    public Account getTargetAccount() {
        return targetAccount;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "sourceAccount=" + sourceAccount +
                ", targetAccount=" + targetAccount +
                ", transactionDate=" + transactionDate +
                ",id=" + id+
                '}';
    }
}
