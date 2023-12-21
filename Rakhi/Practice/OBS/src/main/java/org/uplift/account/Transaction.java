package org.uplift.account;

import java.util.Date;
import java.util.Objects;

public class Transaction {
    private Account sourceAccount;
    private Account targetAccount;
    private Date transactionDate;
    private double amount;
    private String Id;

    public Transaction(Account sourceAccount, Account targetAccount, Date transactionDate, double amount, String id) {
        this.sourceAccount = sourceAccount;
        this.targetAccount = targetAccount;
        this.transactionDate = transactionDate;
        this.amount = amount;
        this.Id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transaction that = (Transaction) o;
        return Double.compare(amount, that.amount) == 0 && Objects.equals(sourceAccount, that.sourceAccount) && Objects.equals(targetAccount, that.targetAccount) && Objects.equals(transactionDate, that.transactionDate) && Objects.equals(Id, that.Id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sourceAccount, targetAccount, transactionDate, amount, Id);
    }

    public String getId() {
        return Id;
    }
}

