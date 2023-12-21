package org.uplift.bank;

import org.uplift.account.Account;
import org.uplift.account.SavingAccount;

import java.util.HashSet;
import java.util.Set;

public class AccountManager {
    private Set<Account> accounts = new HashSet<>();
    public boolean addAccount(Account account) {
        return accounts.add(account);
    }

    public Account findbyAccountNumber(String accountNumber) {
        return accounts.stream().filter(i->i.getAccountNumber().equals(accountNumber)).findFirst().orElse(null);
    }

    public Account findByMobileNumber(String mobileNumber) {
        return accounts.stream().filter(j->j.getUser().getMobile().equals(mobileNumber)).findFirst().orElse(null);
    }

    public Account findByUserName(String userName) {
        return accounts.stream().filter(j->j.getUser().getUserName().equals(userName)).findFirst().orElse(null);
    }
}
