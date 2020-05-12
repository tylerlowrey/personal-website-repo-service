package com.tylerlowrey.personalwebsitereposervice.controllers;

import com.tylerlowrey.personalwebsitereposervice.models.RepoResponse;
import com.tylerlowrey.personalwebsitereposervice.services.RepoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/repos")
@CrossOrigin(origins = "*")
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

        return repoService.getNonForkedRepos();
    }
}
