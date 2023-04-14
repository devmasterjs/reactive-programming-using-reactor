package com.learnreactiveprogramming.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import reactor.test.StepVerifier;

public class FluxAndMonoGeneratorServiceTest {

    FluxAndMonoGeneratorService fluxAndMonoGeneratorService = new FluxAndMonoGeneratorService();

    @Test
    @DisplayName("should return array of names correctly")
    void namesFlux() {
        // given
        byte expectNextCount = 0;

        // when
        var namesFlux = fluxAndMonoGeneratorService.namesFlux();

        // then
        StepVerifier.create(namesFlux)
                .expectNext("alex", "ben", "chloe")
                .expectNextCount(expectNextCount)
                .verifyComplete();
    }

    @Test
    @DisplayName("must return an array name")
    void nameFlux() {
        // given
        byte expectNextCount = 2;
        String expectName = "alex";

        // when
        var namesFlux = fluxAndMonoGeneratorService.namesFlux();

        // then
        StepVerifier.create(namesFlux)
                .expectNext(expectName)
                .expectNextCount(expectNextCount)
                .verifyComplete();
    }

    @Test
    @DisplayName("should return Mono name correctly")
    void namesMono() {
        // given
        byte expectNextCount = 0;
        String expectName = "alex";

        // when
        var nameMono = fluxAndMonoGeneratorService.nameMono();

        // then
        StepVerifier.create(nameMono)
                .expectNext(expectName)
                .expectNextCount(expectNextCount)
                .verifyComplete();
    }

}
