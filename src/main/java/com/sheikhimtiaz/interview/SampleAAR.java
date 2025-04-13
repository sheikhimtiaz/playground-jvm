package com.sheikhimtiaz.interview;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//VantageLabs
public class SampleAAR {

    static List<Integer> initialPrime = Arrays.asList(2,3);
    static Set<Integer> primeNumbers = new HashSet<>();

    static int MAX_CALCULATED_INTEGER_PRIME = 2;


    public static void run() throws InterruptedException {
        System.out.println(primeNumbers);

//        aaga = ???

//        printPrimeNumbers(20);

//        checkThreadStuff();
    }

    //    Write a program to print prime numbers from 1 to N
    private static void printPrimeNumbers (int N) {
        for(int i=2; i<=N;i++) {
            if(isPrime(i)) {
                System.out.println(i);
            }
        }
    }

    private static boolean isPrime(int number) {
        if(primeNumbers.contains(number)) return true;
        if(number < MAX_CALCULATED_INTEGER_PRIME) return false;
        for(int i = MAX_CALCULATED_INTEGER_PRIME; i < number; i++) {
            if(number % i == 0) {
                return false;
            }
        }
        primeNumbers.add(number);
        return true;
    }

    private static void checkThreadStuff() throws InterruptedException {
        Counter counter = new Counter();
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                counter.increment();
            }
        });
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                counter.increment();
            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("Final Counter Value: " + counter.getCount());
    }

    /**
     * Counter class
     */
    static class Counter {
        private int count = 0;
        public void increment() {
            count++;
        }
        public int getCount() {
            return count;
        }
    }
}
