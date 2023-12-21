package org.uplift.account;

import javafx.beans.value.ObservableBooleanValue;
import org.uplift.exception.InSufficientBalanceException;
import org.uplift.user.User;

public interface Account {
    public double showBalance();
    public double deposite(double amount);
    public double withdraw(double amount) throws InSufficientBalanceException;

    String getAccountNumber();
    User getUser();
//    public String findAccountNumber();
}

