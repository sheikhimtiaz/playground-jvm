package com.sheikhimtiaz.basicpractice;

import com.sheikhimtiaz.FoobarChallenge;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SamplePracticeProblem {

    public static void run() {
        int[] arr1 = {1,2,4,7,8};
        int[] arr2 = {3,5,6,9,14};
        FoobarChallenge.printArray(mergeTwoSortedArray(arr1,arr2));

        // Create an array
        String[] array = {"apple", "banana", "orange"};
        // Convert the array to list
        List<String> list = Arrays.asList(array);
        // Print the list
        System.out.println("List: " + list);


        int[] intArray = {1, 2, 3, 4, 5};
        // Convert the int array to List<Integer>
        List<Integer> intList = IntStream.of(intArray).boxed().collect(Collectors.toList());
        // Print the list
        System.out.println("List: " + intList);
    }

    public static int[] mergeTwoSortedArray(int[] arr1, int[] arr2) {
        int i=0, j=0, index = 0;
        int[] res = new int[arr1.length + arr2.length];
        while(i < arr1.length && j < arr2.length){
            if(arr1[i] <= arr2[j]){
                res[index] = arr1[i]; index++; i++;
            } else {
                res[index] = arr2[j]; index++; j++;
            }
        }
        while(i < arr1.length){
            res[index] = arr1[i]; index++; i++;
        }
        while(j < arr2.length){
            res[index] = arr2[j]; index++; j++;
        }
        return res;
    }
}
