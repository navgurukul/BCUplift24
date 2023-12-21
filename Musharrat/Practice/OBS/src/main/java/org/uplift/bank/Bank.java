package org.uplift.bank;

import org.uplift.account.Account;
import org.uplift.user.User;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Bank {
    private Map<String, User> userMap = new HashMap<>();
    private Map<Account, User> userAccountMap = new HashMap<>();
    private Set<User> currentlyLoggedInUser;

    public void addAccount(Account account){
        User user = account.getUser();
        userAccountMap.put(account, user);
        userMap.put(user.getUserName(), user);
    }


    public Map<String, User> getUserMap() {
        return userMap;
    }
}
