package com.nttdata.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientNationalizeConfig {

    @Value("${api.public.nationalize.url}")
    private String baseNationalizeUrl = "https://api.nationalize.io/";

    @Bean
    public WebClient.Builder webClientBuilder() {
        return WebClient.builder()
                .baseUrl(baseNationalizeUrl)
                .defaultHeaders(headers -> headers.add("User-Agent", "MyApp"))
                .defaultHeaders(headers -> headers.add("Accept", "application/json"));
    }

    @Bean
    public WebClient webClient(WebClient.Builder builder) {
        return builder.build();
    }
}