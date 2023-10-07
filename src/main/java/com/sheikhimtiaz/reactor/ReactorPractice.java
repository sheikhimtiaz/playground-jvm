package com.sheikhimtiaz.reactor;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import reactor.core.publisher.ConnectableFlux;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static java.lang.Math.E;
import static java.time.Duration.ofSeconds;
import static java.util.stream.Collectors.toList;

public class ReactorPractice {

    public static void run() {
        System.out.println("## Reactor Practice");

        Flux<Integer> justFlux = Flux.just(1, 2, 3, 4);

        Mono<Integer> justMono = Mono.just(1);

        List<Integer> elements = new ArrayList<>();

        Flux.just(1, 2, 3, 4)
                .log()
                .subscribe(elements::add);

        System.out.println(elements);

        Flux.just(1, 2, 3, 4)
                .log()
                .subscribe(new Subscriber<Integer>() {
                    @Override
                    public void onSubscribe(Subscription s) {
                        s.request(Long.MAX_VALUE);
                    }

                    @Override
                    public void onNext(Integer integer) {
                        elements.add(integer);
                    }

                    @Override
                    public void onError(Throwable t) {}

                    @Override
                    public void onComplete() {}
                });

        // It still might appear that we have something synonymous to a Java 8 Stream doing collect:
        List<Integer> collected = Stream.of(1, 2, 3, 4)
                .collect(toList());
        // Only we don't.
        // The core difference is that Reactive is a push model, whereas the Java 8 Streams are a pull
        // model. In a reactive approach, events are pushed to the subscribers as they come in.

        // Backpressure
        Flux.just(1, 2, 3, 4)
                .log()
                .subscribe(new Subscriber<Integer>() {
                    private Subscription s;
                    int onNextAmount;

                    @Override
                    public void onSubscribe(Subscription s) {
                        this.s = s;
                        s.request(2);
                    }

                    @Override
                    public void onNext(Integer integer) {
                        elements.add(integer);
                        onNextAmount++;
                        if (onNextAmount % 2 == 0) {
                            s.request(2);
                        }
                    }

                    @Override
                    public void onError(Throwable t) {}

                    @Override
                    public void onComplete() {}
                });

        Flux.just(1, 2, 3, 4)
                .log()
                .map(i -> i * 2)
                .subscribe(elements::add);

//        Flux.just(1, 2, 3, 4)
//                .log()
//                .map(i -> i * 2)
//                .zipWith(Flux.range(0, Integer.MAX_VALUE),
//                        (one, two) -> String.format("First Flux: %d, Second Flux: %d", one, two))
//                .subscribe(elements::add);


        // Hot streams
        // One way to create a hot stream is by converting a cold stream into one.
        // Let's create a Flux that lasts forever, outputting the results to the console,
        // which would simulate an infinite stream of data coming from an external resource:
        ConnectableFlux<Object> publish = Flux.create(fluxSink -> {
                    while(true) {
                        fluxSink.next(System.currentTimeMillis());
                    }
                })
                .publish();

        publish.subscribe(System.out::println);
        publish.subscribe(System.out::println);
        // Starts emitting when we call connect
//        publish.connect();


        // Throttling
        // there are multiple strategies to reduce the amount of data
        // sent downstream, such as windowing and buffering
        ConnectableFlux<Object> publishThrottle = Flux.create(fluxSink -> {
                    while(true) {
                        fluxSink.next(System.currentTimeMillis());
                    }
                })
                .sample(ofSeconds(2))
                .publish();

//        publishThrottle.connect();

        System.out.println("## Concurrency");

        List<Integer> elementsPar = new ArrayList<>();
        Flux.just(1, 2, 3, 4)
                .log()
                .map(i -> i * 2)
                .subscribeOn(Schedulers.parallel())
                .subscribe(elementsPar::add);

        System.out.println(elementsPar);

        System.out.println("## End");
    }
}
