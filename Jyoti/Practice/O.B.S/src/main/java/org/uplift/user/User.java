package org.uplift.user;
public class User {
    private String name;
    private  String phone;
    private String email;
    private String userId;
    private String password;

    public User(String name, String phone, String email, String userId, String password) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.userId = userId;
        this.password = password;
    }
}
