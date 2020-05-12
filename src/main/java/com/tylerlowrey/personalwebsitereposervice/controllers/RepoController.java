package com.tylerlowrey.personalwebsitereposervice.controllers;

import com.tylerlowrey.personalwebsitereposervice.models.RepoResponse;
import com.tylerlowrey.personalwebsitereposervice.services.RepoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/repos")
public class RepoController
{
    private final RepoService repoService;

    @Autowired
    public RepoController(RepoService repoService)
    {
        this.repoService = repoService;
    }

    @GetMapping
    public Flux<RepoResponse> getAllRepos(@RequestParam(required = false, defaultValue = "false") boolean showForked)
    {
        if(showForked)
        {
            return repoService.getReposAsync();
        }

        return repoService.getUsersNonForkedRepos();
    }
}
