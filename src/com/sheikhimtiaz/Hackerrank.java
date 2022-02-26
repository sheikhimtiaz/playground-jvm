package com.sheikhimtiaz;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Hackerrank {

    public static void run() {
        System.out.println(reverseArray(new ArrayList<Integer>(Arrays.asList(1,2,3,4,5))));
        System.out.println(powerSum(100,2));
        System.out.println(Solve(6));
        System.out.println(Solve(28));
        System.out.println(maxOperationOfReducingOne(5,6,7)); // not expected output
        System.out.println(maxOperationOfReducingOne(2,3,4)); // not expected output
        //
    }

    private static long maxOperationOfReducingOne(long a, long b, long c){
        // NOT_SOLVED_YET
        long result=0;
        if(a==b) return a;
        if(c==b) return b;
        if(a==c) return c;

        if(a>b){
            long temp = a;
            a = b;
            b = temp;
        }
        if(b>c){
            long temp = c;
            c = b;
            b = temp;
        }
        if(a>c){
            long temp = a;
            a = c;
            c = temp;
        }

        return a + ( (c-a) < b ? c-a : b );
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
