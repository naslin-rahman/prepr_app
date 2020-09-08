package com.example.prepr;

public class User {
    String userName;
    String password;
    String saved;

    public User(String[] userData){
        userName = userData[0];
        password = userData[1];
        saved = userData[2];
    }
}
