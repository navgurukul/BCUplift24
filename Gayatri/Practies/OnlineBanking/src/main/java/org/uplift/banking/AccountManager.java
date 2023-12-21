package org.uplift.banking;

import org.uplift.account.Account;

import java.util.HashSet;
import java.util.Set;

public class AccountManager {

    private Set<Account> accounts = new HashSet<>();

    public boolean addAccount(Account account) {
        return accounts.add(account);
    }

    public Account finByAccountNumber(String accountNumber) {
        return accounts.stream().filter((a) -> (a.getAccountNumber().equals(accountNumber))).findFirst().orElse(null);
    }


    public Account findMyMobile(String mobileNumber){
        return accounts.stream().filter(a-> a.getUser().getMobile().equals(mobileNumber)).findFirst().orElse(null);
    }

    public Account findMyUsername(String username) {
        return accounts.stream().filter(a-> a.getUser().getUsername().equals(username)).findFirst().orElse(null);

    }
}