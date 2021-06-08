package com.unity.githubAPI.service.impl;

import com.google.gson.Gson;
import com.unity.githubAPI.dto.RepositoryInfoDto;
import com.unity.githubAPI.service.GithubService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import java.util.HashMap;
import java.util.Optional;

@Service
public class GithubServiceImpl implements GithubService {

    private Logger LOGGER = LoggerFactory.getLogger(GithubServiceImpl.class);
    private WebClient githubApiClient = WebClient.create("https://api.github.com/");

    @Override
    public Optional<RepositoryInfoDto> getRepositoryInfo(String userName, String repoName) {

        try {
            String response = githubApiClient.get()
                    .uri("/repos/{userName}/{repoName}", userName, repoName)
                    .retrieve()
                    .bodyToMono(String.class).block();
            HashMap map = new Gson().fromJson(response, HashMap.class);


            RepositoryInfoDto repositoryInfoDto = new RepositoryInfoDto.Builder()
                    .fullName((String) map.get("name"))
                    .description((String) map.get("description"))
                    .cloneUrl((String) map.get("clone_url"))
                    .stars((Double) map.get("stargazers_count"))
                    .createdAt((String) map.get("created_at"))
                    .build();
            return Optional.of(repositoryInfoDto);
        } catch (WebClientResponseException  ex){
            LOGGER.info(ex.getResponseBodyAsString());
            return Optional.empty();
        }
    }
}
