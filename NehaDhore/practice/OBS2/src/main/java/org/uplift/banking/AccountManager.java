package org.uplift.bank;

import org.uplift.account.Account;

import java.util.HashSet;
import java.util.Set;

import static java.util.spi.ToolProvider.findFirst;

public class AccountManager {
    private Set<Account> accounts = new HashSet<>();

    public boolean addAccount(Account account){

        return accounts.add(account);
    }

    public Account findByAccountnumber(String accountNumber) {
        return  accounts.stream().filter((a)-> a.getAccountNumber().equals(accountNumber)).findFirst().orElse(null);
    }

    public Account findByMobile(String mobile){
        return accounts.stream().filter((a)-> a.getMobile().equals(mobile)).findFirst().orElse(null);
    }

    public Account findByUsername(String username) {
        return accounts.stream().filter((a)-> a.getUser().getUsername().equals(username)).findFirst().orElse(null);

    }
}
