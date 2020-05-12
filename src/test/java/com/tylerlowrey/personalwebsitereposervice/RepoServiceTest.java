package com.tylerlowrey.personalwebsitereposervice;

import com.tylerlowrey.personalwebsitereposervice.services.RepoService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import reactor.test.StepVerifier;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RepoServiceTest
{
    @Autowired
    private RepoService repoService;

    @Test
    public void reposListIsNotEmpty()
    {
        StepVerifier.create(repoService.getUsersReposAsync("tylerlowrey"))
                    .expectNext();
    }
}
