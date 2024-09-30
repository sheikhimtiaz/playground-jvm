package com.sheikhimtiaz.datatypes;

import java.util.*;
import java.util.stream.Collectors;

public class HashMapSort {


    public static void run() {
        System.out.println("Hashmap sort!!");

        Map<String, Employee> map = new HashMap<>();

        Employee employee1 = new Employee(1L, "Mher");
        map.put(employee1.getName(), employee1);
        Employee employee2 = new Employee(22L, "Annie");
        map.put(employee2.getName(), employee2);
        Employee employee3 = new Employee(8L, "John");
        map.put(employee3.getName(), employee3);
        Employee employee4 = new Employee(2L, "George");
        map.put(employee4.getName(), employee4);

        TreeMap<String, Employee> sorted = new TreeMap<>(map);

        TreeMap<String, Employee> sorted2 = new TreeMap<>();
        sorted2.putAll(map);

        List<String> employeeByKey = new ArrayList<>(map.keySet());
        Collections.sort(employeeByKey);

        List<Employee> employeeById = new ArrayList<>(map.values());

        Collections.sort(employeeById);

        Employee employee5 = new Employee(1L, "Mher");
        map.put(employee5.getName(), employee5);
        Employee employee6 = new Employee(22L, "Annie");
        map.put(employee6.getName(), employee6);

        SortedSet<String> keySet = new TreeSet<>(map.keySet());

        SortedSet<Employee> values = new TreeSet<>(map.values());

        map.entrySet()
                .stream()
                .sorted(Map.Entry.<String, Employee>comparingByKey())
                .forEach(System.out::println);

        map.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .forEach(System.out::println);

        Map<String, Employee> result = map.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));

        // Using Guava library
//        Ordering naturalOrdering = Ordering.natural()
//                .onResultOf(Functions.forMap(map, null));
//
//        ImmutableSortedMap.copyOf(map, naturalOrdering);

        String unit = "()";
        String res = "";
        for(int i=0;i<8;i++){
            res = res.concat(unit);
        }
        System.out.println(res);


    }
}