package com.lanou.demo.bean;

import com.lanou.demo.service.UserLogin;
import com.lanou.demo.service.UserRegister;
import com.lanou.demo.validator.IdCard;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

public class User {
    @NotBlank(message = "用户名不能为空",groups = {UserLogin.class, UserRegister.class})
    private String username;
    @NotBlank(message = "密码不能为空",groups = {UserLogin.class, UserRegister.class})
    private String password;
    @NotBlank(message = "昵称不能为空",groups = {UserRegister.class})
    private String nickname;
    @NotBlank(message = "邮箱不能为空",groups = {UserRegister.class})
    @Email(message = "请输入正确的邮箱",groups = {UserRegister.class})
    private String email;
    @NotBlank(message = "身份证不能为空",groups = {UserRegister.class})
    @IdCard(message = "身份证输入不合法",groups = {UserRegister.class})
    private String id;


    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", nickname='" + nickname + '\'' +
                ", email='" + email + '\'' +
                ", id='" + id + '\'' +
                '}';
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
