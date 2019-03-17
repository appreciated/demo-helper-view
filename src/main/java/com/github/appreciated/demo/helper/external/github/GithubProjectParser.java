package com.github.appreciated.demo.helper.external.github;

import com.github.appreciated.demo.helper.entity.GithubDependencies;
import com.github.appreciated.demo.helper.entity.Project;
import com.github.appreciated.demo.helper.external.ProjectParser;
import org.json.JSONObject;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


public class GithubProjectParser implements ProjectParser {
    static Map<String, Project> parsedProjects = new HashMap<>();
    private String[] projectUrls;

    /**
     * Please provide the complete url f.e:
     * https://github.com/appreciated/vaadin-app-layout/
     *
     * @param dependencies
     */
    public GithubProjectParser(GithubDependencies dependencies) {
        this.projectUrls = dependencies.getDependencies();
        Arrays.stream(projectUrls)
                .filter(s -> !parsedProjects.containsKey(s))
                .forEach(projectUrl -> {
                    String actualProjectUrl = "https://api.github.com/repos/" + projectUrl.substring("https://github.com/".length());
                    HttpClient client = HttpClient.newHttpClient();
                    HttpRequest request = HttpRequest.newBuilder()
                            .uri(URI.create(actualProjectUrl))
                            .GET()
                            .build();
                    client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                            .thenApply(HttpResponse::body)
                            .thenAccept(s -> parseProject(projectUrl, s))
                            .join();
                });
    }

    private void parseProject(String url, String json) {
        JSONObject project = new JSONObject(json);
        parsedProjects.put(
                url,
                new Project(
                        project.getString("full_name"),
                        project.getJSONObject("owner").getString("avatar_url"),
                        project.getJSONObject("owner").getString("html_url")
                ));
    }

    @Override
    public Project[] getProjects() {
        return Arrays.stream(projectUrls).map(s -> parsedProjects.get(s)).toArray(Project[]::new);
    }
}