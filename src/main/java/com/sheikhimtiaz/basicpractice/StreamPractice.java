package com.sheikhimtiaz.basicpractice;

import com.sheikhimtiaz.FoobarChallenge;

import java.util.Arrays;

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
        var sth = Arrays.stream(simpleArray).map(item -> item*2).mapToObj(item -> "N"+item).toArray();
        var sth2 = Arrays.asList(simpleArray).stream().map(i -> i.toString()).toList();
        var sth3 = Arrays.stream(simpleArray).map(item -> item*2).mapToObj(item -> "N"+item).toList();
        System.out.println(sth);
        System.out.println(sth2);
        System.out.println(sth3);
    }
}
