package com.sheikhimtiaz;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ToptalTest {


    public static void run(){
        int[] denos;
        denos = getChange(5, .99);
        for(int item:denos){
            System.out.println(item);
        }

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
