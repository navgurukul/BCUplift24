package org.uplift.banking;

import org.uplift.account.Account;

import java.util.HashSet;
import java.util.Set;

public class AccountManager {
    private Set<Account> accounts = new HashSet<>();

    public boolean addAccount(Account account) {
        return accounts.add(account);
    }

    public Set<Account> getAccounts() {
        return accounts;
    }

    public Account findAccountByAccountNumber(String accountNumber) {
        return accounts.stream()
                .filter(account -> account.getAccountNumber().equals(accountNumber))
                .findFirst().orElse(null);

    }

    public Account findAccountByPhoneNumber(String number) {
        return accounts.stream()
                .filter(account -> account.getUser().getMobile().equals(number))
                .findFirst().orElse(null);
    }

    public Account findAccountByUserName(String userName) {
        return accounts.stream()
                .filter(account -> account.getUser().getUserName().equals(userName))
                .findFirst().orElse(null);
    }
}
