package org.uplift.bank;


import org.uplift.account.Account;

import java.util.HashSet;
import java.util.Set;

public class AccountManager {

    private Set<Account> accounts = new HashSet<>();
    public boolean addAccount(Account account) {
        return accounts.add(account);
    }
}
