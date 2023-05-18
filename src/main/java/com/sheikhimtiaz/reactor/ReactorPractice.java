package com.sheikhimtiaz.reactor;

import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.List;

public class ReactorPractice {

    public static void run() {
        System.out.println("## Reactor Practice");

        List<Integer> elements = new ArrayList<>();

        Flux.just(1, 2, 3, 4)
                .log()
                .subscribe(elements::add);
    }
}
