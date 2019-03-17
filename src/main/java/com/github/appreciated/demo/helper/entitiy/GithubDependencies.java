package com.github.appreciated.demo.helper.entitiy;

import java.util.Arrays;

public class GithubDependencies extends Dependencies {
    public GithubDependencies(String... dependencies) {
        super(dependencies);
        if (Arrays.stream(dependencies).filter(s -> s.startsWith("https://github.com")).count() != dependencies.length) {
            throw new IllegalStateException("GithubDependencies must only contain Github urls");
        }
    }
}
