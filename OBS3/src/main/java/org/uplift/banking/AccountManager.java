package org.uplift.banking;

import org.uplift.account.Account;

import java.util.HashSet;
import java.util.Set;

public class AccountManager {

    private Set<Account> accounts = new HashSet<>();
    public boolean addAccount(Account account) {
        return accounts.add(account);
    }

    public Account findByAccountNumber(String accountNumber) {
        return accounts.stream().filter((a)->a.getAccountNumber().
                equals(accountNumber)).findFirst().orElse(null);
    }

    public Account findByPhoneNumber(String accountPhoneNumber) {
        return accounts.stream().filter((a)->a.getPhoneNumber().
                equals(accountPhoneNumber)).findFirst().orElse(null);
    }

    public Account findByUserName(String userName) {
        return accounts.stream().filter((a)->a.getUserName().
                equals(userName)).findFirst().orElse(null);
    }
}
