package com.sheikhimtiaz;


import com.sheikhimtiaz.datatypes.Pair;

import java.util.ArrayList;
import java.util.List;

public class FoobarChallenge {

    public static void run() {
//        Level 1 problem - solar doomsday
//        int[] res = solarDoomsDaySolution(12);
//        printArray(res);
//        int[] res2 = solarDoomsDaySolution(15324);
//        printArray(res2);
//        res = solarDoomsDaySolution(20);
//        printArray(res);

//        int res = dontGetVolunteered(0,1);
//        System.out.println(res);
//        System.out.println(dontGetVolunteered(19, 36));

//        System.out.println(enRouteSalute("--->-><-><-->-"));
//        System.out.println(enRouteSalute(">----<"));
//        System.out.println(enRouteSalute("<<>><"));
//        System.out.println(17^18^19^20^21^22^23^25^26^29);
//        System.out.println(queueToDo(17,4));
//        System.out.println(queueToDo(0,3));
    }

    public static int queueToDo(int start, int length){
        int result = 0, it = length;
        for(int i=0;i<length;i++){
            for(int j=0;j<length;j++){
                if(j<it){
                    result = result ^ start;
                }
                start++;
            }
            it--;
        }
        return result;
    }

    public static int enRouteSalute(String s) {
        int res = 0;
        String possibleIntersectionStr = trimNonIntersectingEmployees(s);
        for(int i=0;i<possibleIntersectionStr.length()-1;i++){
            if (">".equals(possibleIntersectionStr.substring(i,i+1))) {
                for(int j=i+1;j<possibleIntersectionStr.length();j++){
                    if("<".equals(possibleIntersectionStr.substring(j,j+1))) res++;
                }
            }
        }
        return res*2;
    }

    public static String trimNonIntersectingEmployees(String s){
        int beginIndex = 0, endIndex = s.length();
        while(beginIndex < s.length()-1){
            if(">".equals(s.substring(beginIndex, beginIndex+1))) break;
            else beginIndex++;
        }
        while(endIndex > 0){
            if("<".equals(s.substring(endIndex-1, endIndex))) break;
            else endIndex--;
        }
        return s.substring(beginIndex, endIndex);
    }

    public static int dontGetVolunteered(int src, int dest) {
        Pair source = getCoordinates(src);
        Pair destination = getCoordinates(dest);
        List<Pair> checked = new ArrayList<>();
        List<Pair> process = new ArrayList<>();
        checked.add(source);
        process.add(source);
        int step = 0;
        boolean found = false;
        while(!found && checked.size() <= 64){
            if(process.indexOf(destination) >= 0) {
                found = true; break;
            }
            else step += 1;
            List<Pair> nextPoints = new ArrayList<>();
            for(int i=0; i<process.size();i++){
                Pair currItem = process.get(i);
                if(currItem.x - 1 >= 0 && currItem.y - 2 >= 0) nextPoints.add(new Pair(currItem.x - 1, currItem.y - 2));
                if(currItem.x - 2 >= 0 && currItem.y - 1 >= 0) nextPoints.add(new Pair(currItem.x - 2, currItem.y - 1));
                if(currItem.x + 1 < 8 && currItem.y + 2 < 8) nextPoints.add(new Pair(currItem.x + 1, currItem.y + 2));
                if(currItem.x + 2 < 8 && currItem.y + 1 < 8) nextPoints.add(new Pair(currItem.x + 2, currItem.y + 1));
                if(currItem.x - 1 >= 0 && currItem.y + 2 < 8) nextPoints.add(new Pair(currItem.x - 1, currItem.y + 2));
                if(currItem.x + 1 < 8 && currItem.y - 2 >= 0) nextPoints.add(new Pair(currItem.x + 1, currItem.y - 2));
                if(currItem.x - 2 >= 0 && currItem.y + 1 < 8) nextPoints.add(new Pair(currItem.x - 2, currItem.y + 1));
                if(currItem.x + 2 < 8 && currItem.y - 1 >= 0) nextPoints.add(new Pair(currItem.x + 2, currItem.y - 1));
            }
            process = new ArrayList<>();
            for(int i=0;i<nextPoints.size();i++){
                if(checked.indexOf(nextPoints.get(i)) < 0) {
                    checked.add(nextPoints.get(i));
                    process.add(nextPoints.get(i));
                }
            }
        }
        return step;
    }

    private static Pair getCoordinates(int num) {
        return new Pair(num/8, num%8);
    }

    public static void printArray(int myArr[]){
        for(int i=0; i<myArr.length; i++){
            if(i != 0) System.out.print(", ");
            System.out.print(myArr[i]);
        }
        System.out.println("");
    }

    public static void printArrayChar(char myArr[]){
        for(int i=0; i<myArr.length; i++){
            if(i != 0) System.out.print(", ");
            System.out.print(myArr[i]);
        }
        System.out.println("");
    }
    public static void printArrayChar(char myArr[], String title){
        System.out.print(title + " -> ");
        printArrayChar(myArr);
    }

    public static int[] solarDoomsDaySolution(int area) {
        int[] res = {};
        while(area > 0){
            int largestSquare = getLargestSquare(area);
            res = addItemToArray(res, largestSquare);
            area = area - largestSquare;
        }
        return res;
    }


    private static int getLargestSquare(int n){
        int possibleSquare = 0;
        int low = 0, high = 1000;
        while(low < high){
            int mid = (low+high) / 2;
            if(n >= (mid+1)*(mid+1)){
                possibleSquare = mid+1;
                low = mid+1;
            }
            else high = mid;
        }
        return possibleSquare * possibleSquare;
    }

    private static int[] addItemToArray(int arr[], int itemToAdd){
        int[] newArr = new int[arr.length + 1];
        System.arraycopy(arr, 0, newArr, 0, arr.length);
        newArr[arr.length] = itemToAdd;
        return newArr;
    }

}
