package org.example.user;

public class User {
    private String name;
    private String mobileNumber;
    private String email;
    private String userName;
    private String password;

    public User(String name, String mobileNumber, String email, String userName, String password) {
        this.name = name;
        this.mobileNumber = mobileNumber;
        this.email = email;
        this.userName = userName;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }
}
