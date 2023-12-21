package org.uplift.banking;

import org.uplift.account.Account;

import java.util.HashSet;
import java.util.Set;

public class AccountManager {
    private Set<Account> userAccount=new HashSet<>();
    public boolean addAccount(Account account) {
        return userAccount.add(account);
    }

    public Account findByAccountNumber(String accountNumber) {
        return userAccount.stream().filter(account -> account.getAccountNumber().equals(accountNumber))
                .findFirst().orElse(null);
    }

    public Account findByMobile(String mobileNumber){
        return userAccount.stream().filter(account -> account.getUser().getMobile().equals(mobileNumber))
                .findFirst().orElse(null);
    }

    public Account findByUserName(String userName){
        return userAccount.stream().filter(account -> account.getUser().getUserName().equals(userName))
                .findFirst().orElse(null);
    }
}
