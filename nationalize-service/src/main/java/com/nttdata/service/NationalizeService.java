package com.nttdata.service;

import com.nttdata.service.model.NationalDTO;
import reactor.core.publisher.Mono;

public interface NationalizeService {

    Mono<NationalDTO> getNationalizeResponse(String name);
}