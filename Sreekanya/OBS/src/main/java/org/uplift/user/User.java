package org.uplift.user;

import org.uplift.account.Account;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class User {
    private String name;
    private String mobileNum;
    private String email;
    private String username;
    private String password;
    private Map<String,String> userInfo=new HashMap<>();

    public User(String name, String mobileNum, String email, String username, String password) {
        this.name = name;
        this.mobileNum = mobileNum;
        this.email = email;
        this.username = username;
        this.password = password;
        userInfo.put(email,password);
    }

    public String capturePassword(){
        System.out.println("password:");
        Scanner s=new Scanner(System.in);
        return s.next();
    }
    public String captureUserEmail(){
        System.out.println("Email:");
        Scanner s=new Scanner(System.in);
        return s.next();
    }
    public boolean isValid(){
        System.out.println("enter user email");
        if(userInfo.containsValue(captureUserEmail())){
            String pw=userInfo.get(captureUserEmail());
            for(int i=0;i<3;i++){
                if(pw.equals(capturePassword())) {
                    break;
                }return true;

            }

        }return false;
    }
}
