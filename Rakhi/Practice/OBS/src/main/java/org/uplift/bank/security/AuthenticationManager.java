package org.uplift.bank.security;

import org.uplift.bank.AccountManager;

public class AuthenticationManager {
    private AccountManager bank;
    public boolean logIn(String userName,String password){
        String thisUserPassword=bank.getUserMap().get(userName).getPassword();
        if(bank.getUserMap().containsKey(userName) && thisUserPassword.equals(password)){
            return true;
        }else return false;
    }
}
