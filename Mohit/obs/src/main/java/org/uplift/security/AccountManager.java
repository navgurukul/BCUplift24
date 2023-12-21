package org.uplift.security;

import org.uplift.account.Account;

import java.util.HashSet;
import java.util.Set;

public class AccountManager {
    private Set<Account> accountSet=new HashSet<>();
    public boolean addAccount(Account account) {
        return accountSet.add(account);

    }
    public Account findAccountNumber(String accountNumber){
        return accountSet.stream().filter(a->a.getAccountNumber().equals(accountNumber))
                .findFirst().orElse(null);
    }

    public Account findAccountByMobile(String number) {
        return accountSet.stream()
                .filter(account -> account.getUser().getMobile().equals(number))
                .findFirst().orElse(null);
    }
    public Account findAccountByUserName(String userName){
        return accountSet.stream()
                .filter(account -> account.getUser().getUsername().equals(userName))
                .findFirst().orElse(null);
    }
}
