package org.uplift.user;

public class User {
    public User(String name, String mobile, String email, String userName, String password) {
        this.name = name;
        this.mobile = mobile;
        this.email = email;
        this.userName = userName;
        this.password = password;
    }

    private String name;
    private String mobile;
    private String email;
    private String userName;
    private String password;

    public String getPassword() {
        return password;
    }
}
