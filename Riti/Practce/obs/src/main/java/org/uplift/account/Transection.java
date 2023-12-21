package org.uplift.account;

import java.util.Date;
import java.util.Objects;

public class Transection {
    private Account sourceAccount;
    private Account targetAccount;
    private Date transectionDate;
    private double amount;
    private String transectionID;

    public Transection(Account sourceAccount, Account targetAccount,double amount, Date transectionDate, String transectionID) {
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


    //comparing the transections on the basses of all the espects;;
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Transection that)) return false;
        return Double.compare(getAmount(), that.getAmount()) == 0 && Objects.equals(getSourceAccount(), that.getSourceAccount()) && Objects.equals(getTargetAccount(), that.getTargetAccount()) && Objects.equals(getTransectionDate(), that.getTransectionDate()) && Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSourceAccount(), getTargetAccount(), getTransectionDate(), getAmount(), getId());
    }

    public String getId() {
        return transectionID;
    }
}
