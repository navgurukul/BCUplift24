package org.uplift.user;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class User {
    private String name;
    private String mobile;
    private String username;
    private String password;
    private String email;
    private Scanner scanner;
    private Map<String,String> userInfo = new HashMap<>();

    public User(String name, String mobile, String username, String password,String email) {
        this.name = name;
        this.mobile = mobile;
        this.username = username;
        this.password = password;
        this.email=email;

        userInfo.put(mobile,password);
    }

    public String captureEmail() {
        System.out.println("Enter Email");
        String s = scanner.next();
        return s;
    }
    public String capturePassword() {
        System.out.println("Enter Password");
        Scanner scanner1 = new Scanner(System.in);
        String s = scanner1.next();
        return s;
    }
    public boolean valid() {
        for(int i=0; i<3; i++) {
            String email1 = captureEmail();
            if (userInfo.containsKey(email1)) {
                for (int j=0; j<3; j++) {
                    String passwprd1 = userInfo.get(email1);
                    if (passwprd1.equals(capturePassword())) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
