package org.uplift.User;

public class User {
    private String name;
    private String userName;
    private String password;
    private String mobile;
    private String email;

    public User(String name, String userName, String password, String mobile, String email) {
        this.name = name;
        this.userName = userName;
        this.password = password;
        this.mobile = mobile;
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", mobile='" + mobile + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
