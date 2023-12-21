package org.uplift.account;

import java.util.Date;
import java.util.Objects;

public class Transaction {
    private  double amount;
    private Account sourceAccount;
    private Account targetAccount;
    private Date transactionDate;
    private String id;

    public Transaction(Account sourceAccount, Account targetAccount, Date transactionDate,double amount,String id) {
        this.sourceAccount = sourceAccount;
        this.targetAccount = targetAccount;
        this.transactionDate = transactionDate;
        this.amount=amount;
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

    public double getAmount() {
        return amount;
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

    @Override
    public boolean equals(Object o) {  // because we do transactions assertEquals
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transaction that = (Transaction) o;
        return Objects.equals(sourceAccount, that.sourceAccount) && Objects.equals(targetAccount, that.targetAccount) && Objects.equals(transactionDate, that.transactionDate) && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sourceAccount, targetAccount, transactionDate, id);
    }
}
