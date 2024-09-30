package com.sheikhimtiaz.builtinmethods;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class BuiltInMethods {
    public static void run() {
//        int val = Math.abs(-5);
//        System.out.println(val);
//
//        inheritenceAgain();
//
//        checkSynchronizedKeyword();

//        checkDifferentKindsOfSets();

//        checkFailSafeIterator();

//        List<String> immutableList = List.of("Item1", "Item2", "Item3");

        // Attempting to modify the immutableList will throw UnsupportedOperationException
//         immutableList.add("Item4"); // This will throw an exception

//        System.out.println(immutableList);


    }

    private static void checkFailSafeIterator() {
        ConcurrentHashMap<Integer, String> map = new ConcurrentHashMap<>();
        map.put(1, "One");
        map.put(2, "Two");
        map.put(3, "Three");

        // Create an iterator
        Iterator<Integer> iterator = map.keySet().iterator();

        while (iterator.hasNext()) {
            Integer key = iterator.next();
            System.out.println(key);

            // Simulate concurrent modification (no exception thrown)
            if (key == 2) {
                map.remove(key);
            }
            System.out.println(map);
        }
    }

    private static void inheritenceAgain() {
        Animal myAnimal = new Animal();
        Animal myDog = new Dog();

        // Calling the method from the superclass
        myAnimal.speak();

        // Calling the overridden method in the subclass
        myDog.speak();

        Animal c = new Dog();
        c.speak();
    }

    private static void checkSynchronizedKeyword() {
        final SharedCounter counter = new SharedCounter();

        Runnable task = () -> {
            for (int i = 0; i < 10000; i++) {
                counter.increment();
            }
        };

        Thread thread1 = new Thread(task);
        Thread thread2 = new Thread(task);

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("Final Count: " + counter.getCount());
    }

    private static void checkDifferentKindsOfSets() {
        int numElements = 1000000;
        ArrayList<Integer> randomList = new ArrayList<>();
        Random random = new Random();
        for(int i=0;i<numElements;i++){
            randomList.add(random.nextInt());
        }

        long startTime = System.nanoTime();
        HashSet<Integer> hashSet = new HashSet<>();
        for (int i = 0; i < numElements; i++) {
            hashSet.add(i);
        }
        long endTime = System.nanoTime();
        long hashSetTime = endTime - startTime;

        startTime = System.nanoTime();
        LinkedHashSet<Integer> linkedHashSet = new LinkedHashSet<>();
        for (int i = 0; i < numElements; i++) {
            linkedHashSet.add(i);
        }
        endTime = System.nanoTime();
        long linkedHashSetTime = endTime - startTime;

        startTime = System.nanoTime();
        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int i = 0; i < numElements; i++) {
            treeSet.add(i);
//            treeSet.add(randomList.get(i)); // try adding random numbers see the spike lmao
        }
        endTime = System.nanoTime();
        long treeSetTime = endTime - startTime;

        System.out.println("HashSet Time (ns): \t\t\t" + hashSetTime);
        System.out.println("LinkedHashSet Time (ns): \t" + linkedHashSetTime);
        System.out.println("TreeSet Time (ns): \t\t\t" + treeSetTime);
    }
}
class SharedCounter {
    private int count = 0;

    // Synchronized method ensures thread safety
    public synchronized void increment() {
        count++;
    }

    public int getCount() {
        return count;
    }
}

class Animal {
    // Method in superclass
    void speak() {
        System.out.println("Animal speaks");
    }
}

class Dog extends Animal {
    // Overriding the speak method in the subclass
    @Override
    void speak() {
        System.out.println("Dog barks");
    }
}

