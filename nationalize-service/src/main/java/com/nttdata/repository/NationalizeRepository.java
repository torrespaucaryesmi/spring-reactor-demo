package com.nttdata.repository;

import com.nttdata.repository.model.NationalizeResponse;
import reactor.core.publisher.Mono;

public interface NationalizeRepository {

    Mono<NationalizeResponse> getNationalizeResponse(String name);
}
