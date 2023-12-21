package org.uplift.account;

import java.util.Date;
import java.util.Objects;

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


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transaction that = (Transaction) o;
        return Double.compare(amount, that.amount) == 0 && Objects.equals(sourceAccount, that.sourceAccount) && Objects.equals(targetAccount, that.targetAccount) && Objects.equals(transaction, that.transaction) && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sourceAccount, targetAccount, transaction, amount, id);
    }

    public String getId(){
        return id;
    }
}
