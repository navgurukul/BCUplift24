package org.uplift.user;

public class User{
    private String name;



    private String mobile;
    private  String email;

    public String getUserName() {
        return userName;
    }

    private String userName;
    private  String password;

    public String getMobile() {
        return mobile;
    }


    public User(String name, String mobile, String email, String userName, String password) {
        this.name = name;
        this.mobile = mobile;
        this.email = email;
        this.userName = userName;
        this.password = password;
    }
}
