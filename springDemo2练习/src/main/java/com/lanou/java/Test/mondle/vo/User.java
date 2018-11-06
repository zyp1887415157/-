package com.lanou.java.Test.mondle.vo;

public class User {
    String user;

    @Override
    public String toString() {
        return "User{" +
                "user='" + user + '\'' +
                '}';
    }

    public User(String user) {
        this.user = user;
    }
}
