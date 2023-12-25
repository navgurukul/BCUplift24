package org.uplift.account;

import org.uplift.exceptions.InsuffucentBalanceException;
import org.uplift.user.User;

public interface Account {
    public double showBalance();
    public double deposit(double amount);
    public double withdraw(double amount) throws InsuffucentBalanceException;
    public String getAccountNumber();
    public String getMobileNumber();
    public User getUser();
    public String getUserName();


}
