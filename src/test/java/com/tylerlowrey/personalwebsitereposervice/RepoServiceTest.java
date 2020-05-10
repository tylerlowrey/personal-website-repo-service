package com.tylerlowrey.personalwebsitereposervice;

import com.tylerlowrey.personalwebsitereposervice.services.RepoService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.test.StepVerifier;

@SpringBootTest
public class RepoServiceTest
{
    private RepoService repoService = new RepoService();


    @Test
    public void reposListIsNotEmpty()
    {
        StepVerifier.create(repoService.getReposAsync("tylerlowrey"))
                    .expectNextMatches(repoList -> !repoList.isEmpty())
                    .verifyComplete();
    }
}
