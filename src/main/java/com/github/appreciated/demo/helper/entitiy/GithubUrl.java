package com.github.appreciated.demo.helper.entitiy;

public class GithubUrl {
    private String url;

    public GithubUrl(String url) {
        this.url = url;
        if (url == null || !url.startsWith("https://github.com")) {
            throw new IllegalStateException("GithubUrl must be a Github url");
        }
    }

    public String getUrl() {
        return url;
    }
}
