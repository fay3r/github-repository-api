package com.unity.githubAPI.controller;

import com.google.gson.Gson;
import com.unity.githubAPI.dto.RepositoryInfoDto;
import com.unity.githubAPI.service.GithubService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class GithubController {

    private GithubService githubService;

    private static final Logger LOGGER = LoggerFactory.getLogger(GithubController.class);

    @Autowired
    public GithubController(GithubService githubService) {
        this.githubService = githubService;
    }

    @CrossOrigin
    @GetMapping(value = "/repositories/{userName}/{repoName}",produces = "application/json")
    public ResponseEntity getRepositoryDetails(@PathVariable String userName, @PathVariable String repoName){
        LOGGER.info("Author: {} , repository: {}",userName,repoName);
        Optional<RepositoryInfoDto> optional = githubService.getRepositoryInfo(userName,repoName);
        return optional.isPresent()  ? new ResponseEntity<>(optional.get(), HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND) ;
    }
}
