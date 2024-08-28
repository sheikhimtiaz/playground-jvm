package com.sheikhimtiaz.interview;

public class Micro1Interview {
    public static void run() {
        System.out.println(exists(new int[][]{ new int[]{1,3,5,7},
                                            new int[]{10,11,16,20},
                                            new int[]{23,30,34,60}} , 3) );
    }

    public static boolean exists(int[][] arr, int target) {
        boolean result = false;
        int[] start = {0,0};
        int[] end = {arr.length, arr[0].length};
        // 00 01 02 03 => 00 12
        // 10 11 12 12
        // 20 21 22 23 => 21 23
        while(isStartSmallerThanEnd(start, end)) {
            int[] mid = getMidPoint(start, end);
            if(arr[mid[0]][mid[1]] == target) return true;
            else if (arr[mid[0]][mid[1]] < target) {
                end[0] = mid[0];
                end[1] = mid[1];
            }
            else {
                start[0] = mid[0];
                start[1] = mid[1];
            }
        }
        return result;
    }

    private static int[] getMidPoint(int[] start, int[] end) {
        int dist  = ((end[0] - start[0]) + (end[1] - start[1]));
        return new int[]{start[0]+ dist, start[1]+ dist};
    }

    private static boolean isStartSmallerThanEnd(int[] start, int[] end) {
        if(start[0] < end[0]) return true;
        else if (start[0] == end[0]) return start[1] < end[1];
        else return false;
    }


}
