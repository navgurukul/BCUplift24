package org.uplift.account;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.Objects;

public class Transaction {
    private Account sourceAccount;
    private Account targetaccount;
    private Date transactionData;
    private double amount;
    private String id;
    public Transaction(Account sourceAccount, Account targetaccount, Date transactionData, double amount, String id) {
        this.sourceAccount = sourceAccount;
        this.targetaccount = targetaccount;
        this.transactionData = transactionData;
        this.amount = amount;
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transaction that = (Transaction) o;
        return Double.compare(amount, that.amount) == 0 && Objects.equals(sourceAccount, that.sourceAccount) && Objects.equals(targetaccount, that.targetaccount) && Objects.equals(transactionData, that.transactionData) && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sourceAccount, targetaccount, transactionData, amount, id);
    }

    public String getId() {
        return id;
    }

}
