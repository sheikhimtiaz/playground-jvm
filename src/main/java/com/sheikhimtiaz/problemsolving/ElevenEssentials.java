package com.sheikhimtiaz.problemsolving;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ElevenEssentials {
    public static void run(){
        List<Integer> arr1 = new ArrayList<Integer>();
        arr1.add(3);
        arr1.add(5);
        arr1.add(7);
        List<Integer> arr2 = new ArrayList<Integer>();
        arr2.add(5);
        arr2.add(7);
        arr2.add(3);
        List<Integer> arr3 = new ArrayList<Integer>(Arrays.asList(3,5,7));
        System.out.println(IsOneArrayRotationOfAnother(arr1, arr3));
    }

    private static boolean IsOneArrayRotationOfAnother(List<Integer> arr1, List<Integer> arr2){
        System.out.println(arr1);
        System.out.println(arr2);
        if(arr1.size() != arr2.size()) return false;

        Integer arrIndex1 = 0;
        Integer arrIndex2 = 0;

        boolean foundStartingPoint = false;

        for (arrIndex2 = 0; arrIndex2 < arr2.size(); arrIndex2++) {
            if(arr1.get(arrIndex1) == arr2.get(arrIndex2)){
                foundStartingPoint = true;
                break;
            }
        }

        if(foundStartingPoint == false) return false;

        while(arrIndex1 < arr1.size()){
            if(arr1.get(arrIndex1) != arr2.get(arrIndex2)){
                return false;
            }
            arrIndex1++;
            if(arrIndex2 < (arr2.size() - 1)){
                arrIndex2++;
            } else {
                arrIndex2 = 0;
            }
        }

        return true;
    }
}
