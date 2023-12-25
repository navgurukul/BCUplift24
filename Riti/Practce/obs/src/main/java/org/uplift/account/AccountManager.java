package org.uplift.account;

import jdk.internal.icu.text.UnicodeSet;

import java.util.HashSet;
import java.util.Set;

import static java.util.spi.ToolProvider.findFirst;

public class AccountManager {

    private Set<Account> accounts=new HashSet<>();
    private Account accountNumber;


    public boolean addManager(Saving account) {
        return accounts.add(account);
    }

    public Account findByAccountNumber(String number) {
        return   accounts.stream().filter(a->a.getAccountNumber().equals(number)).findFirst().orElse(null);
    }

    public Account findByMobileNumber(String number) {
        return accounts.stream().filter((a)->a.getUser().getPhone().equals(number)).findFirst().orElse(null);
    }

    public Account findByUserName(String UserName) {
        return   accounts.stream().filter(a->a.getUser().getUserName().equals(UserName)).findFirst().orElse(null);
    }
}
