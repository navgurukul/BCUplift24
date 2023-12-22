package org.example.bankingprovider;


import org.example.account.Account;

import java.util.HashSet;
import java.util.Set;

public class AccountManager {

    private Set<Account> accounts = new HashSet<>();

    public boolean addAccount(Account account) {
        return accounts.add(account);
    }

    public Account findByAccountNumber(String accountNo) {
         return accounts.stream().filter((account -> account.getAccountNo().equals(accountNo))).
                findFirst().orElse(null);
    }

    public Account findByPhoneNumber(String mobile) {
        return accounts.stream().filter(account -> account.getUser().getMobile().equals(mobile))
                .findFirst().orElse(null);
    }

    public Account findByUserName(String userName) {
        return accounts.stream().filter(account -> account.getUser().getUserName().equals(userName))
                .findFirst().orElse(null);
    }
}
