package com.nttdata.repository.impl;

import com.nttdata.repository.NationalizeRepository;
import com.nttdata.repository.model.NationalizeResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Slf4j
@Repository
@AllArgsConstructor
public class NationalizeRepositoryImpl implements NationalizeRepository {

    private final WebClient webClient;

    public Mono<NationalizeResponse> getNationalizeResponse(String name) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/")
                        .queryParam("name", name)
                        .build())
                .retrieve()
                .bodyToMono(NationalizeResponse.class);
    }
}
