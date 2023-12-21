package org.uplift.user;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class User {
    private String name;
    private String mobile;
    private String email;
    private String username;
    private String password;
    private Scanner scanner;
    private Map<String, String> userDetails = new HashMap<>();

    public User(String name, String mobile, String email, String username, String password) {
        this.name = name;
        this.mobile = mobile;
        this.email = email;
        this.username = username;
        this.password = password;
        userDetails.put(username, password);
    }

    public String captureUsername() {
        System.out.println("Enter Username");
        Scanner scanner1 = new Scanner(System.in);
        String s = scanner.next();
        return s;
    }

    public String capturePassword() {
        System.out.println("Enter Password");
        Scanner scanner1 = new Scanner(System.in);
        String s = scanner1.next();
        return s;
    }
    public boolean isValid() {
        for(int i=0; i<3; i++) {
            String email1 = captureUsername();
            if (userDetails.containsKey(email1)) {
                for (int j=0; j<3; j++) {
                    String password1 = userDetails.get(email1);
                    if (password1.equals(capturePassword())) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}

