package com.sheikhimtiaz;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ToptalTest {

    static List<Integer> amicableTable = new ArrayList(Collections.nCopies(20000, 0));
    int[] amicableTable2 = new int[2000];

    public static void run(){
//        int[] denos;
//        denos = getChange(5, .99);
//        for(int item:denos){
//            System.out.println(item);
//        }


        System.out.println(findAmicablePairs(230)); // 1

    }


    public static int findAmicablePairs(int N){
        // NOT_SOLVED_YET
        int result = 0;
        for (int i=1;i<=N;i++){
            if(isNumberAmicable(i)){
                result++;
            }
        }
        return result;
    }

    public static boolean isNumberAmicable(int N){
        return amicableTable.get(N) == 1 ? true : false;
    }

    public static void checkIfNumberIsAmicable(){
        for(int i=0;i<20000;i++)
            amicableTable.set(i, checkIfNumberIsAmicableHelper(i));
    }

    public static int checkIfNumberIsAmicableHelper(int N){
        if(N <= 1) return 0;
        int properDivisorSum = 1;
        for(int i=2;i<=N/2;i++){

        }
        return 0;
    }

    public static long arrayManipulation(int n, List<List<Integer>> queries) {
        // List<Integer> array = new ArrayList<Integer>();
        // IntStream.range(1, n).forEach(i -> {
        //     array.add(0);
        // });
        ArrayList<Integer> intlist = new ArrayList<Integer>(Collections.nCopies(n, 0));
        Integer result = 0;
        for(int i=0;i<intlist.size();i++){
            for(int j=0;j<queries.size();j++){
                if((i+1)>= queries.get(j).get(0) && (i+1)<=queries.get(j).get(1)){
                    Integer temp = intlist.get(i)+queries.get(j).get(2);
                    if(result< temp) result =temp;
                    intlist.set(i, temp);
                }
            }
        }
        return (long)result;
    }


    public static int[] getChange(double money, double target){
        double result = 0.0;
        int[] denos = {0, 0, 0, 0, 0, 0};
        int[] coins = {1, 5, 10, 25, 50, 100};
        result = (money - target) * 100;
        int index = 5;
        int takenChange = 0;
        for(int i=index; i>=0 ; i--){
            if(result >= coins[i]){
                denos[i] = (int) result / coins[i];
                takenChange += coins[i] * denos[i];
                result = result - takenChange;
            }
        }
        return denos;
    }

}
