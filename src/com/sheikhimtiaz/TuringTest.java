package com.sheikhimtiaz;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

//import static org.junit.Assert.assertEquals;

public class TuringTest {

    public static void run() {
        double nth = Math.pow(625, 1.0 / 4.0);
        System.out.println(nth);
//        assertEquals(5, nth, 0.00001);

        int n=3;
        char[] str = new char[2*n];
        printParenthesis(n);

//        int[] myIntArray1 = new int[3];
//        printIntArray(myIntArray1);
//        int[] myIntArray2 = {1, 2, 3};
//        printIntArray(myIntArray2);
//        int[] myIntArray3 = new int[]{1, 2, 3};
//        printIntArray(myIntArray3);

        // Since Java 8. Doc of IntStream: https://docs.oracle.com/javase/8/docs/api/java/util/stream/IntStream.html

//        int [] myIntArray4 = IntStream.range(0, 10).toArray(); // From 0 to 99
//        printIntArray(myIntArray4);
//        int [] myIntArray5 = IntStream.rangeClosed(0, 10).toArray(); // From 0 to 100
//        printIntArray(myIntArray5);
//        int [] myIntArray6 = IntStream.of(12,25,36,85,28,96,47).toArray(); // The order is preserved.
//        printIntArray(myIntArray6);
//        int [] myIntArray7 = IntStream.of(12,25,36,85,28,96,47).sorted().toArray(); // Sort
//        printIntArray(myIntArray7);
//
//        int[] myIntArray8 = new int[10];
//        printIntArray(myIntArray8);
//
//        boolean[] myBoolArray = new boolean[10];
//        printBoolArray(myBoolArray);
    }

    private static void printBoolArray(boolean[] input) {
        for (int i=0;i<input.length;i++){
            System.out.print(input[i] + " ");
        }
        System.out.println();
    }
    private static void printIntArray(int[] input) {
        for (int i=0;i<input.length;i++){
            System.out.print(input[i] + " ");
        }
        System.out.println();
    }

    private static void printParenthesis( int n) {
        // NOT_SOLVED_YET - understand
        char[] str = new char[2*n];
        List<String> result = new ArrayList<>();
        if(n>0)
            _printParenthesis(result, str,0,n,0,0);
        System.out.println(result);
    }

    private static void _printParenthesis(List<String> result, char[] str, int pos, int n, int open, int close) {
        if(close == n){
            for(int i=0;i<str.length;i++)
                System.out.print(str[i]);
            System.out.println();

            result.add(String.valueOf(str));
            return;
        }else {
            if(open > close){
                str[pos] = ')';
                _printParenthesis(result, str, pos+1, n, open, close+1);
            }
            if(open < n){
                str[pos] = '(';
                _printParenthesis(result, str, pos+1, n, open+1, close);
            }
        }
    }



}
