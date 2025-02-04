package com.nttdata;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@ExtendWith(MockitoExtension.class)
@Slf4j
class MyApplicationTests {

    @Test
    void contextLoads() {
        Flux<Integer> flux = Flux.just(1, 2, 3, 4, 5)
                .map(i -> {
                    if (i == 3) throw new RuntimeException("Boom!"); // Error en el número 3
                    return i;
                })
                .onErrorContinue((e, x) -> Mono.just(e.getMessage())); // Reemplaza el error con el valor 3

        flux.subscribe(System.out::println, System.err::println);
    }

    @Test
    void test1() {
        Flux<Integer> flux = Flux.just(1, 2, 3, 4, 5)
                .map(i -> {
                    if (i == 3) throw new RuntimeException("Boom!"); // Error en el número 3
                    return i;
                })
                .onErrorResume(e -> {
                    System.err.println("Error ocurrido: " + e.getMessage());
                    return Flux.just(10, 11, 12); // Reemplaza el error con 3 y continúa el flujo
                });

        flux.subscribe(System.out::println, System.err::println);
    }

    @Test
    void test2() {
        Flux<Integer> flux = Flux.just(1, 2, 3, 4, 5)
                .map(i -> {
                    if (i == 3) throw new RuntimeException("Boom!"); // Error en el número 3
                    return i;
                })
                .onErrorReturn(10);

        flux.subscribe(System.out::println, System.err::println);
    }

    @Test
    void test3() {
        Flux<Integer> flux = Flux.just(1, 2, 3, 4, 5)
                .flatMap(i -> {
                    if (i == 3) {
                        return Mono.error(new RuntimeException("Boom!")); // Lanzamos error en 3
                    }
                    return Mono.just(i);
                })
                .onErrorContinue((e, x) -> Mono.just(e.getMessage()));

        flux.subscribe(System.out::println, System.err::println);
    }
}