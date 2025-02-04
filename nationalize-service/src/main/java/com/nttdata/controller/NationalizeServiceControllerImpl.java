package com.nttdata.controller;

import com.nttdata.service.NationalizeService;
import com.nttdata.service.model.NationalDTO;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/nationalize")
@AllArgsConstructor
public class NationalizeServiceControllerImpl {
    
    private final NationalizeService nationalizeService;

    @GetMapping()
    public Mono<NationalDTO> getNationality(@RequestParam String name) {
        return nationalizeService.getNationalizeResponse(name);
    }
}
