package org.uplift.account.Bank;
import org.uplift.account.*;
import java.util.HashSet;
import java.util.Set;

public class AccountManager {
    private Set<Account> accountset = new HashSet<>();
    public boolean addAccount(Account account){
        return accountset.add(account);
    }
    public Account findByAccountNumber(String accountNumber){
        return accountset.stream()
                .filter(a -> a.getAccountNumber().equals(accountNumber))
                .findFirst()
                .orElse(null);
    }
    public Account findByUserMobileNo(String mobileNo) {
        return accountset.stream()
                .filter(a -> a.getUser().getMobile().equals(mobileNo))
                .findFirst()
                .orElse(null);
    }
    public SavingAccount findByUserName(String username) {
        return (SavingAccount) accountset.stream()
                .filter(a -> a.getUser().getUserName().equals(username))
                .findFirst()
                .orElse(null);
    }
}
