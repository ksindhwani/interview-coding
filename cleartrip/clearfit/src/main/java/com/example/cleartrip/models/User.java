package com.example.cleartrip.models;

public class User {

    int userId;
    String name;
    
    public User(int userId, String name) {
        this.userId = userId;
        this.name = name;
    }

    public int getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }
    
}
