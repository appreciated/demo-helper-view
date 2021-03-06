package com.github.appreciated.demo.helper.external.github;

import com.github.appreciated.demo.helper.entity.Contributor;
import com.github.appreciated.demo.helper.external.ContributorParser;
import org.json.JSONArray;
import org.json.JSONObject;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.*;

public class GithubContributorParser implements ContributorParser {

    static Map<String, GithubContributorParser> parsers = new HashMap<>();

    private Contributor[] contributors = new Contributor[]{};

    /**
     * Please provide the complete url f.e:
     * https://github.com/appreciated/vaadin-app-layout/
     *
     * @param projectUrl
     */
    private GithubContributorParser(String projectUrl) {
        if (projectUrl.startsWith("https://github.com/")) {
            projectUrl = "https://api.github.com/repos/" + projectUrl.substring("https://github.com/".length()) + "/contributors";
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(projectUrl))
                    .GET()
                    .build();
            client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                    .thenAccept(s -> {
                        if (s.statusCode() >= 200 && s.statusCode() <= 299) {
                            parseUsers(s.body());
                        } else {
                            System.err.println("Github Request failed with " + s.statusCode());
                        }
                    })
                    .join();
        }
    }

    private void parseUsers(String json) {
        JSONArray users = new JSONArray(json);
        List<JSONObject> objects = new ArrayList<>();
        for (int i = 0; i < users.length(); i++) {
            objects.add(users.getJSONObject(i));
        }
        contributors = objects.stream()
                .map(object -> new Contributor(
                        object.getString("login"),
                        object.getString("avatar_url"),
                        object.getString("html_url")
                ))
                .toArray(Contributor[]::new);
    }

    public static void main(String[] args) {
        Arrays.stream(GithubContributorParser.getInstance("https://github.com/appreciated/vaadin-app-layout").getContributors()).forEach(contributor -> {
            System.out.println(contributor.getName());
        });
    }

    public Contributor[] getContributors() {
        return contributors;
    }

    public static GithubContributorParser getInstance(String projectUrl) {
        if (!parsers.containsKey(projectUrl)) {
            parsers.put(projectUrl, new GithubContributorParser(projectUrl));
        }
        return parsers.get(projectUrl);
    }
}
