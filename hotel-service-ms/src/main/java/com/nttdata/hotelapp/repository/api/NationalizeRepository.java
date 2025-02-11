package com.nttdata.hotelapp.repository.api;

import com.nttdata.hotelapp.repository.api.dto.NationalizeResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
public class NationalizeRepository {

    private final WebClient webClient;

    public NationalizeRepository(WebClient webClient) {
        this.webClient = webClient;
    }

    public Mono<NationalizeResponse> getNationalizeResponse(String name) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/app-nationalize/nationalize")
                        .queryParam("name", name)
                        .build())
                .retrieve()
                .bodyToMono(NationalizeResponse.class);
    }

}
