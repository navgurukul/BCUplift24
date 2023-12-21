package org.uplift.bank;

import org.uplift.account.Account;

import java.util.HashSet;
import java.util.Set;

public class AccountManager {

    private Set<Account> accounts = new HashSet<>();
    public boolean addAccount(Account account) {
        return accounts.add(account);
    }

    public Account findByAccountNumber(String accountNumber) {
        return accounts.stream().filter((a) -> a.getAccountNumber().equals(accountNumber)).findFirst().orElse(null);
    }

    public Account findByPhoneNumber(String mobileNumber) {
        return accounts.stream().filter(account -> account.getUser().getMobile().equals(mobileNumber)).findFirst().orElse(null);
    }

    public Account findByUserName(String userName) {
        return accounts.stream().filter(account -> account.getUser().equals(userName)).findFirst().orElse(null);
    }
}
