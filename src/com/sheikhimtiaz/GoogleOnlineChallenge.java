package com.sheikhimtiaz;

import java.util.ArrayList;
import java.util.Arrays;

public class GoogleOnlineChallenge {


    public static void run() {
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


//        return a + ( (c-a) < b ? c-a : b );
        return maxOperationOfReducingOneRecursive(a,b,c);
    }


    private static long maxOperationOfReducingOneRecursive(long a, long b, long c){
        if(a==0 && b==0 || b==0 && c==0 || a==0 && c==0) return 0;

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
        return 1+maxOperationOfReducingOneRecursive(a,b-1,c-1);
    }


}
