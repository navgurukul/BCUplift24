package org.uplift.account;

import java.util.HashSet;
import java.util.Set;

public class AccountManager {

    private Set<Account> accounts = new HashSet<>();
    public boolean addManager(Account account) {
        return accounts.add( account );
    }

    public Account findByAccountNumber(String accountNumber) {

        return accounts.stream().filter(a -> a.getAccountNumber().equals( accountNumber )).findFirst().orElse(null);
    }

    public Account findByMobileNumber(String mobileNumber){

        return accounts.stream().filter(a -> a.getUser().getMobile().equals( mobileNumber )).findFirst().orElse(null);
    }

    public Account findByUserName(String username) {
        return accounts.stream().filter(a -> a.getUser().getUsername().equals( username )).findFirst().orElse( null );
    }
}
