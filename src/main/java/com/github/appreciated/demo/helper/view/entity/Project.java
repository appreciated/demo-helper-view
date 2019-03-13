package com.github.appreciated.demo.helper.view.entity;

public class Project {
    String name;
    String imagePath;
    private String projectUrl;

    public Project(String name, String imagePath, String projectUrl) {
        this.name = name;
        this.imagePath = imagePath;
        this.projectUrl = projectUrl;
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
}
