package com.tylerlowrey.personalwebsitereposervice.services;

import com.tylerlowrey.personalwebsitereposervice.models.RepoResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class RepoService
{
    private static final String BASE_API_URL = "https://api.github.com/";

    @Value("${github.api.key}")
    private String apiKey;

    private final WebClient webClient = WebClient.create(BASE_API_URL);

    public Mono<List<RepoResponse>> getReposAsync(String username)
    {
        String path = "/user/repos?sort=update&type=all";
        return webClient.get()
                 .uri(path, username)
                 .header("Authorization", "token " + apiKey)
                 .retrieve()
                 .bodyToMono(new ParameterizedTypeReference<>() {});
    }


}
