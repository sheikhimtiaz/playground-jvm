package com.sheikhimtiaz.reactor;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;

public class MonoPractice {

    public static void run(){
        System.out.println("# Mono");
        String expected = "Hello world!";

        String result = blockingHelloWorld().block();
        assertEquals(expected, result);

        String result2 = blockingHelloWorld().block(Duration.of(1000, ChronoUnit.MILLIS));
        assertEquals(expected, result2);

        Optional<String> result3 = Mono.<String>empty().blockOptional();
        assertEquals(Optional.empty(), result3);
        blockingHelloWorld()
                .log()
//                .subscribeOn(Schedulers.parallel())
                .subscribe(result4 -> assertEquals(expected, result4));

        blockingHelloWorld()
                .log()
                .doOnNext(result5 -> assertEquals(expected, result5))
                .subscribe();
    }

    private Mono<List<String>> monoOfList() {
        List<String> list = new ArrayList<>();
        list.add("one");
        list.add("two");
        list.add("three");
        list.add("four");

        return Mono.just(list);
    }

    private <T> Flux<T> monoTofluxUsingFlatMapMany(Mono<List<T>> monoList) {
        return monoList
                .flatMapMany(Flux::fromIterable)
                .log();
    }
    private <T> Flux<T> monoTofluxUsingFlatMapIterable(Mono<List<T>> monoList) {
        return monoList
                .flatMapIterable(list -> list)
                .log();
    }

    static Mono<String> blockingHelloWorld() {
        return Mono.just("Hello world!");
    }

}
