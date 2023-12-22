package org.uplift.account;

import java.util.Date;
import java.util.Objects;

public class Transaction {
    private Account sourceAccount;
    private Account targetAccount;
    private Date transactionDate;
    private String transactionId;
    private double amount;

    public Transaction(Account sourceAccount, Account targetAccount, Date transactionDate, double amount, String transactionId) {
        this.sourceAccount = sourceAccount;
        this.targetAccount = targetAccount;
        this.transactionDate = transactionDate;
        this.amount = amount;
        this.transactionId = transactionId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transaction that = (Transaction) o;
        return Objects.equals(sourceAccount, that.sourceAccount) && Objects.equals(targetAccount, that.targetAccount) && Objects.equals(transactionDate, that.transactionDate) && Objects.equals(transactionId, that.transactionId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sourceAccount, targetAccount, transactionDate, transactionId);
    }

    public String getTransactionId() {
        return transactionId;
    }
}