package com.lanou.bookstore.user.domain;

import java.util.Arrays;
import java.util.List;

public class User {
    private String username;
    private String password;
    private String UUID;
    private String email;
    private String code;
    private String state;
    private String uid;

    public String getUid() {
        return uid;
    }

    public User setUid(String uid) {
        this.uid = uid;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public User setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getCode() {
        return code;
    }

    public User setCode(String code) {
        this.code = code;
        return this;
    }

    public String getState() {
        return state;
    }

    public User setState(String state) {
        this.state = state;
        return this;
    }

    public String getUUID() {
        return UUID;
    }

    public User setUUID(String UUID) {
        this.UUID = UUID;
        return this;
    }






    public String getUsername() {
        return username;
    }

    public User setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

}
