package com.example.project1;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Accounts implements Serializable {

    private List<User> Accounts;

    public Accounts() {
        Accounts = new ArrayList<>();
        Accounts.add(new User("ayman", "123"));
    }

    public List<User> getAccounts() {
        return Accounts;
    }

    public void setAccounts(List<User> accounts) {
        Accounts = accounts;
    }


    public User FoundByUsername(String name) {
        for (User user : Accounts) {
            if (user.getUsername().equals(name)) {
                return user;
            }
        }

        return null;
    }
}
