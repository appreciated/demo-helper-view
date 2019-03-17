package com.github.appreciated.demo.helper.entity;

public class Contributor {
    String userName;
    String avatarUrl;
    private String url;

    public Contributor(String login, String imagePath, String url) {
        this.userName = login;
        this.avatarUrl = imagePath;
        this.url = url;
    }

    public String getName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getUrl() {
        return url;
    }
}
