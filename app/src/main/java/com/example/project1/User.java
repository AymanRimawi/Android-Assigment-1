package com.example.project1;

public class User {
    private String Username;
    private String Password;
    private arrayOfDays Days;

    public User(String username, String password) {
        Username = username;
        Password = password;
        Days=new arrayOfDays();
    }

    public arrayOfDays getDays() {
        return Days;
    }

    public void setDays(arrayOfDays Days) {
        Days = Days;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}
