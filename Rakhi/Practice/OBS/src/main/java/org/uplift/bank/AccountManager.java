package org.uplift.bank;

import org.uplift.account.Account;
import org.uplift.user.User;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class AccountManager {
    private Set<Account> userAccount=new HashSet<>();
    public boolean addAccount(Account account) {
        return userAccount.add(account);
    }
}
