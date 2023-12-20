package org.uplift.account;

public class CurrentAccount implements Account {
    @Override
    public double showBalance() {
        return 0;
    }

    @Override
    public boolean deposit(double amount) {
        return false;
    }

    @Override
    public boolean withdraw(double amount) {
        return false;
    }
}
