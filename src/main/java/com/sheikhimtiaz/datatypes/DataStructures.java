package com.sheikhimtiaz.datatypes;

import java.util.HashSet;
import java.util.TreeSet;

public class DataStructures {
    public static void run() {
        HashSet<String> set = new HashSet<>();
        set.add("Date");
        set.add("Cherry");
        set.add("Apple");
        set.add("Banana");
        System.out.println("Hashset: " + set);

        TreeSet<String> treeSet = new TreeSet<>(set);
        treeSet.add("Date");
        treeSet.add("Cherry");
        treeSet.add("Apple");
        treeSet.add("Banana");
        System.out.println("TreeSet: " + treeSet);
    }
}
