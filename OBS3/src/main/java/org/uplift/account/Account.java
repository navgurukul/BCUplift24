package org.uplift.account;

import org.uplift.exceptions.InsufficietBalanceException;

public interface Account {
        public double showBalance();
        public double deposit(double amount);

        public double withdraw(double amount) throws InsufficietBalanceException, InsufficietBalanceException;

        public String getAccountNumber();

        public String getPhoneNumber();

        public String getUserName();


}
