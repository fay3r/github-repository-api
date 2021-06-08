package com.unity.githubAPI.service;

import com.unity.githubAPI.dto.RepositoryInfoDto;
import java.util.Optional;


public interface GithubService {

    Optional<RepositoryInfoDto> getRepositoryInfo(String userName, String repoName);
}
