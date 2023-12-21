package org.uplift.bank;

import org.uplift.user.User;

import java.util.HashMap;
import java.util.Map;

public class Bank {
    private static Map<String, User> userMap=new HashMap<>();
    protected static void addUsers(User u){
        userMap.put(u.getUserName(),u);
    }

    public Map<String,User> getUserMap(){
        return userMap;
    }

}
