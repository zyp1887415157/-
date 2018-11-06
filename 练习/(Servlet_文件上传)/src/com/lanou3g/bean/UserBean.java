package com.lanou3g.bean;

public class UserBean {
    private int userId;
    private int imageId;
    private String username;
    private String password;

    @Override
    public String toString() {
        return "UserBean{" +
                "userId=" + userId +
                ", imageId=" + imageId +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
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
}
