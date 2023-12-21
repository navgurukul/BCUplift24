package org.example.banking;

import org.example.account.Account;
import org.example.account.SavingAccount;

import java.util.HashSet;
import java.util.Set;

public class AccountManager {
    private Set<Account> accounts = new HashSet<>();
    public boolean addAccount(Account account) {
        return accounts.add(account);
    }
    public Account findByAccountNumber(String accountNumber) {
        return accounts.stream().filter(a -> a.getAccountNumber().equals(accountNumber)).findFirst().orElse(null);
    }
    public Account findByMobile(String mobileNumber){
        return accounts.stream().filter(a->a.getUser().getMobileNumber().equals(mobileNumber)).findFirst().orElse(null);
    }

    public SavingAccount findByUsername(String username) {
        return (SavingAccount) accounts.stream().filter(a->a.getUser().getUserName().equals(username)).findFirst().orElse(null);
    }
}
