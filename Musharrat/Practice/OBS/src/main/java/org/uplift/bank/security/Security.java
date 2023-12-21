package org.uplift.bank.security;

import org.uplift.exception.UserNotFoundException;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Security {

    Random random;
    private static Map<String, String> usernamePasswordMap = new HashMap<>();

    public Security(Random random){
        this.random = random;
    }

    public boolean verifyUser(String userName, String password) throws UserNotFoundException {
        if (usernamePasswordMap.containsKey(userName)){
            return usernamePasswordMap.get(userName).equals(password);
        }
        else{
            throw new UserNotFoundException("This user doesn't exists in our bank");
        }
    }

    public void setRandom(Random random){
        this.random = random;
    }

    public static Map<String, String> getUsernamePasswordMap() {
        return usernamePasswordMap;
    }

    public int generateOTP() {
        int otp = random.nextInt(100000, 1000000000);
        return otp;
    }
}
