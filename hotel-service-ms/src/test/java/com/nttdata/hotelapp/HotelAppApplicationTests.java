package com.nttdata.hotelapp;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.Exceptions;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;
import reactor.util.retry.Retry;

import java.time.Duration;
import java.time.LocalTime;
import java.util.concurrent.atomic.AtomicInteger;

@ExtendWith(MockitoExtension.class)
@Log4j2
class HotelAppApplicationTests {

	@Test
	void initialTes() {
		AtomicInteger errorCount = new AtomicInteger();
		Flux<String> flux =
				Flux.<String>error(new IllegalArgumentException())
						.doOnError(e -> errorCount.incrementAndGet())
						.retryWhen(Retry.from(companion ->
								companion.<Long>handle((rs, sink) -> {
									log.info("Retrying {}", rs.totalRetries());
									if (rs.totalRetries() < 3) sink.next(rs.totalRetries());
									else sink.error(Exceptions.propagate(rs.failure()));
								})
						));
		flux.doFinally(signal -> log.info("Signal type: {}, error count: {}", signal, errorCount.get()))
				.subscribe();
	}

	@Test
	void testWhenRetryWithDelay() {
		AtomicInteger errorCount = new AtomicInteger();
		Flux<String> flux =
				Flux.<String>error(new IllegalStateException("boom"))
						.doOnError(e -> {
							errorCount.incrementAndGet();
							log.info(e + " at " + LocalTime.now());
						})
						.retryWhen(Retry
								.backoff(3, Duration.ofMillis(100)).jitter(0d)
								.doAfterRetry(rs ->
										log.info("retried at " + LocalTime.now() +
												", attempt " + rs.totalRetries()))
								.onRetryExhaustedThrow((spec, rs) -> rs.failure())
						);

		StepVerifier.create(flux)
				.expectError(IllegalStateException.class)
				.verify();

		System.out.println("Error count: " + errorCount.get());
		assert errorCount.get() == 4;
	}

}
