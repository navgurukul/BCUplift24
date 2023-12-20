package org.uplift.account;

import java.util.Date;

public class Transection {
    private Account sourceAccount;
    private Account targetAccount;
    private Date transectionDate;
    private double amount;
    private String transectionID;

    public Transection(Account sourceAccount, Account targetAccount, Date transectionDate, double amount, String transectionID) {
        this.sourceAccount = sourceAccount;
        this.targetAccount = targetAccount;
        this.transectionDate = transectionDate;
        this.amount = amount;
        this.transectionID = transectionID;
    }

    public Account getSourceAccount() {
        return sourceAccount;
    }

    public Account getTargetAccount() {
        return targetAccount;
    }

    public Date getTransectionDate() {
        return transectionDate;
    }

    public double getAmount() {
        return amount;
    }

    public String getTransectionID() {
        return transectionID;
    }
}
