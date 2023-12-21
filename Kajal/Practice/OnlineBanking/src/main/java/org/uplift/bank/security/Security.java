package org.uplift.bank.security;

import org.uplift.exception.UserDoesNotExistException;
import org.uplift.user.User;

import java.util.HashMap;
import java.util.Map;

public class Security {
    private Map<String, User> userMap = new HashMap<>();
    private Map<String, String> userpasswordMap = new HashMap<>();

    public Security(Map<String, User> userMap, Map<String, String> userpasswordMap){
        this.userMap = userMap;
        this.userpasswordMap = userpasswordMap;
    }

    public boolean verityUser(String userId, String password) throws UserDoesNotExistException {
        if (!userpasswordMap.containsKey(userId)){
            throw new UserDoesNotExistException("User does not exist");
        }
        else if(!userpasswordMap.get(userId).equals(password)){
            throw new UserDoesNotExistException("User password is incorrect");
        }
        return true;
    }

    public Map<String, User> getUserMap() {
        return userMap;
    }

    public Map<String, String> getUserpasswordMap() {
        return userpasswordMap;
    }

    public void generateOPT() {
    }
}
