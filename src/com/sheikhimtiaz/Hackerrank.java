package com.sheikhimtiaz;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Hackerrank {

    public static void run() {
        System.out.println(reverseArray(Arrays.asList(1,2,3,4,5)));
        System.out.println(powerSum(100,2));
        System.out.println(Solve(6));
        System.out.println(Solve(28));
    }

    static String Solve(int N){
        // Write your code here
        int result = 1;
        if(N==1) return "NO";
        int ans = (int)Math.sqrt(N);
        for(int i=2;i<=ans;i++){
            if(N%i==0){
                result+=i;
                result+=N/i;
            }
        }
        return result == N ? "YES" : "NO";
    }

    public static int powerSum(int X, int N) {
        return findPowerSum(X, N, 1);
    }

    private static int findPowerSum(int total, int power, int num){
        // NOT_SOLVED_YET - understand properly
        int value = (total - (int)Math.pow(num, power));

        if(value < 0) return 0;
        else if(value == 0) return 1;
        else return findPowerSum(value , power, num + 1) +
                    findPowerSum(total, power, num + 1);
    }

    private static List<Integer> reverseArray(List<Integer> a) {
        for(int i=0;i<a.size();i++){
            for (int j=0;j<a.size();j++){
                if(a.get(i) > a.get(j)){
                    Integer temp = a.get(i);
                    a.set(i, a.get(j));
                    a.set(j, temp);
                }
            }
        }
        return a;
    }
}
