package org.uplift.user;

public class User {
    private String name;
    private String mobile;
    private String email;
    private String username;//(which is used for login.)
    private String password;

    public User(String name, String mobile, String email, String username, String password) {
        this.name = name;
        this.mobile = mobile;
        this.email = email;
        this.username = username;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getMobile() {
        return mobile;
    }

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}