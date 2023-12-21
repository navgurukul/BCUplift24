package org.uplift.security;

import org.uplift.bank.Bank;
import org.uplift.user.User;

public class AuthenticationManager {
    private Bank bank;
    public boolean logIn(String userName,String password){
        String thisUserPassword=bank.getUserMap().get(userName).getPassword();
        if(bank.getUserMap().containsKey(userName) && thisUserPassword.equals(password)){
            return true;
        }else return false;
    }
}
