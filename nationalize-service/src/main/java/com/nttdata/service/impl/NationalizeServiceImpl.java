package com.nttdata.service.impl;

import com.nttdata.repository.NationalizeRepository;
import com.nttdata.repository.model.NationalizeResponse;
import com.nttdata.service.NationalizeService;
import com.nttdata.service.model.NationalDTO;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;

import static java.util.Comparator.comparing;

@Service
@Slf4j
@AllArgsConstructor
public class NationalizeServiceImpl implements NationalizeService {

    private final NationalizeRepository nationalizeResponse;

    @Override
    public Mono<NationalDTO> getNationalizeResponse(String name) {
        return nationalizeResponse.getNationalizeResponse(name)
                .map(response -> response.getCountry().stream()
                        .max(comparing(NationalizeResponse.CountryProbability::getProbability))
                        .orElseThrow(() -> new RuntimeException("No country found")))
                .map(country -> NationalDTO.builder()
                        .code(country.getCountryId())
                        .percentage(BigDecimal.valueOf(country.getProbability()))
                        .build())
                .doOnError(throwable -> log.error("Error while fetching nationalize response for name: {}", name, throwable))
                .onErrorResume(throwable -> Mono.just(NationalDTO.builder().code("unknown").percentage(BigDecimal.ZERO).build()));
    }
}