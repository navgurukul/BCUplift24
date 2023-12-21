package org.uplift.user;

import java.util.Scanner;

public class UserVerification {

    public static boolean verifyUser(User user1){
        Scanner input=new Scanner(System.in);
        String password=input.next();
        if (user1.getPassword().equals(password)){
            return true;

        }
        return false;
    }

}
