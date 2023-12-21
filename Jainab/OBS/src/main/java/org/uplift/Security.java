package org.uplift;

import org.uplift.exception.UserDoesNotExistException;
import org.uplift.user.User;

import java.util.HashMap;
import java.util.Map;

public class Security {
    private static Map<String, User> userMap = new HashMap<>();
    private static Map<String, String> userPasswordMap = new HashMap<>();

    public static Map<String, User> getUserMap() {
        return userMap;
    }

    public static Map<String, String> getUserPasswordMap() {
        return userPasswordMap;
    }

    public boolean verifyUser(String userId, String password) throws UserDoesNotExistException {
        if(userPasswordMap.containsKey(userId)){
            if(userPasswordMap.get(userId).equals(password)){
                return true;
            }
            else{
                throw new UserDoesNotExistException("Incorrect Password");
            }
        }
        else {
            throw new UserDoesNotExistException("Invalid User Name...");
        }
    }
}
