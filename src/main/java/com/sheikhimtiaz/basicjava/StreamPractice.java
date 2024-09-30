package com.sheikhimtiaz.basicjava;

import com.sheikhimtiaz.problemsolving.FoobarChallenge;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamPractice {

    public static void run() {
        char[][] matrix = new char[5][5];
        int[][] dp = new int[matrix.length + 1][matrix[0].length + 1];
//        Arrays.stream(matrix).toList().stream().forEach(item -> Foobar.printArrayChar(item));
//        Arrays.stream(dp).toList().stream().forEach(item -> Foobar.printArray(item));
        int[] simpleArray = {5,4,3,2,1,6};
        System.out.println(Arrays.stream(simpleArray).sum());
        System.out.println(Arrays.stream(simpleArray).max());
        System.out.println(Arrays.stream(simpleArray).max().getAsInt());
        FoobarChallenge.printArray(Arrays.stream(simpleArray).sorted().toArray());
        System.out.println(Arrays.stream(simpleArray).map(item -> item*2).mapToObj(item -> "N"+item).toList());
        var sth = Arrays.stream(simpleArray).map(item -> item * 2).mapToObj(item -> "N"+item).toArray();
        System.out.println("t"+5);
        String sgagag = "ag" + 5;
        var sth2 = Stream.of(simpleArray).map(Object::toString).toList();
        var sth3 = Arrays.stream(simpleArray).map(item -> item*2).mapToObj(item -> "N"+item).toList();
        System.out.println(sth);
        System.out.println(sth2);
        System.out.println(sth3);


        List<String> list = Arrays.asList("apple", "apple", "orange", "banana", "grape", "apple", "orange", "banana" );

        var item = list.stream()
                .collect(Collectors.groupingBy(s -> s));

        System.out.println(item);

        var item2 = list.stream()
                .collect(Collectors.groupingBy(s -> s, Collectors.counting()));

        System.out.println(item2);

        // Java 22 feature gatherer, will try later ???
//        list.stream().gather(Collectors.groupingBy(s -> s)).forEach();

        List<String> result = list.stream()
                .collect(Collectors.groupingBy(s -> s, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() > 1)
                .map(Map.Entry::getKey)
                .toList();

        System.out.println(result);

        long numberOfWords =
                Stream.of("the", "", "fox", "jumps", "over", "the", "", "dog")   // (1)
                        .filter(Predicate.not(String::isEmpty))                          // (2)
                        .count();                                                        // (3)
    }

    private static String getStateFromJava8(Student student) {
        Optional<Student> studentOpt = Optional.ofNullable(student);
        // Java 8, remove if else with Optional and lambda functions
        return studentOpt
                .map(Student::getAddress)
                .map(Street::getCity)
                .map(City::getState)
                .map(State::getName)
                .orElse("unknown");
    }

    @Getter
    @AllArgsConstructor
    static class Student {
        private String name;
        private Integer age;
        private Street address;
    }

    @Getter
    @AllArgsConstructor
    static class Street {
        private String name;
        private City city;
    }

    @Getter
    @AllArgsConstructor
    static class City {
        private String name;
        private State state;
    }

    @Getter
    @AllArgsConstructor
    static class State {
        private String name;
    }
}
