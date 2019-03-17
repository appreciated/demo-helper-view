package com.github.appreciated.demo.helper.entity;

public class Project {
    String name;
    String imagePath;
    private String url;

    public Project(String name, String imagePath, String projectUrl) {
        this.name = name;
        this.imagePath = imagePath;
        this.url = projectUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
