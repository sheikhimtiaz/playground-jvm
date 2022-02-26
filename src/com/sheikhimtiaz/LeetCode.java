package com.sheikhimtiaz;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;

public class LeetCode {

    public static void run() {
        int[] arr = {1,2,3};
        System.out.println(distanceBetweenBusStops(arr,0,1));

        System.out.println(numJewelsInStones("aA","aAAbbbbb"));
    }

    public static int numJewelsInStones(String jewels, String stones) {
        int result = 0;
        LinkedHashSet<Character> linkedHashSet = new LinkedHashSet<>();
        for(int j=0;j<jewels.length();j++){
            if(!linkedHashSet.contains(jewels.charAt(j))){
                linkedHashSet.add(jewels.charAt(j));
            }
        }
        for(int i=0;i<stones.length();i++){
            if(linkedHashSet.contains(stones.charAt(i))){
                result++;
            }
        }
        return result;

    }
    public static int distanceBetweenBusStops(int[] distance, int start, int destination) {
        int forward = 0, backward = 0;
        if(start>destination) {
            int temp = start;
            start = destination;
            destination = temp;
        }
        for(int i=0;i<distance.length;i++){
            if(start <= i && i<destination){
                forward += distance[i];
            } else backward += distance[i];
        }
        return Math.min(forward, backward);
    }
}
