package com.github.appreciated.demo.helper.entity;

public class Dependencies {
    private String[] dependencies;

    public Dependencies(String... dependencies) {
        this.dependencies = dependencies;
    }

    boolean hasDependencies() {
        return dependencies != null && dependencies.length > 0;
    }

    public String[] getDependencies() {
        return dependencies;
    }
}
