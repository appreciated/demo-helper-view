package com.github.appreciated.demo.helper.external.github;

import com.github.appreciated.demo.helper.external.ProjectParser;
import com.github.appreciated.demo.helper.view.entity.Project;
import org.json.JSONObject;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.*;


public class GithubProjectParser implements ProjectParser {
    static Map<String, GithubProjectParser> parsers = new HashMap<>();

    private List<Project> projects = new ArrayList<>();

    /**
     * Please provide the complete url f.e:
     * https://github.com/appreciated/vaadin-app-layout/
     *
     * @param projectUrls
     */
    private GithubProjectParser(String... projectUrls) {
        Arrays.stream(projectUrls).forEach(projectUrl -> {
            if (projectUrl.startsWith("https://github.com/")) {
                projectUrl = "https://api.github.com/repos/" + projectUrl.substring("https://github.com/".length());
                HttpClient client = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create(projectUrl))
                        .GET()
                        .build();
                client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                        .thenApply(HttpResponse::body)
                        .thenAccept(this::parseProject)
                        .join();
            }
        });
    }

    private void parseProject(String json) {
        JSONObject project = new JSONObject(json);
        projects.add(new Project(
                project.getString("full_name"),
                project.getJSONObject("owner").getString("avatar_url"),
                project.getJSONObject("owner").getString("html_url")
        ));
    }

    public static GithubProjectParser getInstance(String projectUrl) {
        if (!parsers.containsKey(projectUrl)) {
            parsers.put(projectUrl, new GithubProjectParser(projectUrl));
        }
        return parsers.get(projectUrl);
    }

    @Override
    public Project[] getProjects() {
        return projects.toArray(Project[]::new);
    }
}