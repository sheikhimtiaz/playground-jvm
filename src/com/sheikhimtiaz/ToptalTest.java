package com.sheikhimtiaz;

public class ToptalTest {


    public static void run(){
        int[] denos;
        denos = getChange(5, .99);
        for(int item:denos){
            System.out.println(item);
        }

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
