package org.uplift.account;

import java.util.Date;
import java.util.Objects;

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

    public String getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transaction that = (Transaction) o;
        return Double.compare(amount, that.amount) == 0 && Objects.equals(savingAccount, that.savingAccount) && Objects.equals(targetAccount, that.targetAccount) && Objects.equals(transactionDate, that.transactionDate) && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(savingAccount, targetAccount, transactionDate, amount, id);
    }
}
